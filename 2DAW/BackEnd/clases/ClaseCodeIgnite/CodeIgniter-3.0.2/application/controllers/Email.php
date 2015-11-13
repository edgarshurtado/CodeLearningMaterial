<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Email extends CI_Controller {

  function __construct(){
    parent::__construct();

    date_default_timezone_set("Europe/Madrid");

    $this->load->model('email_model');
    $this->load->helper('url');
  }

  public function index()
  {
    $this->load->view('email');
  }

  public function send()
  {
    $to = $this->input->post('to');
    $emails_to_send = explode(";", $to);
    print_r($emails_to_send);
    $subject = $this->input->post('subject');
    $message = $this->input->post('message');

    if(isset($_FILES['file']['name']) && $_FILES['file']['name'] != null){
      $name = $_FILES['file']['name'];
      $tname = $_FILES['file']['tmp_name'];
      echo "$name <br>  $tname <br>";
      $carpetaServer = FCPATH;
      echo "Carpeta Server : $carpetaServer <br>
            Carpeta server 2: $carpetaServer2 <br>";
      $destination =  $carpetaServer . '/assets/uploads/files/' . $name;
      echo "Destination: $destination";
      move_uploaded_file($tname, $destination);
    }
    $this->email_model->sendMail(
        "daw@iesmariaenriquez.es", $emails_to_send, $subject, $message, $tname
      );
  }

}
