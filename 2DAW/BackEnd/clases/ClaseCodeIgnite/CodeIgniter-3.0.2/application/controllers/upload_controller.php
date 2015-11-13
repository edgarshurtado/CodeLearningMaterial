<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Upload_Controller extends CI_Controller {
    public function __construct()
    {
      parent::__construct();
      $this->load->helper(array('form', 'url', 'download'));
      $this->load->library('upload');
    }

    public function index()
    {
      $this->load->view('upload_form', array('error' => ' '));
    }

    public function download()
    {
       //$data = "Esto es un texto cualquiera";
       $data = "./assets/uploads/files/pdftest.pdf";
       $name = 'Mi_pdf.pdf';
       
       force_download($name, file_get_contents($data));
    }

    public function copy()
    {
       $this->load->dbutil();

       $backup = &$this->dbutil->backup();
       $file_backup = 'backup'.date("YmdHi");
    }

    public function do_upload()
    {
        if(!$this->upload->do_upload()){
           $error = array('error' => $this->upload->display_errors());
           $this->load->view('upload_form', $error);
        }else {
            $data = array('upload_data'=> $this->upload->data());
            $this->load->view('upload_success', $data);
        }
    }
}
