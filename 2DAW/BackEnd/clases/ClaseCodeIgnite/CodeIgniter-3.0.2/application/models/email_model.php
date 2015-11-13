<?php
  /**
  *
  */
  class Email_Model extends CI_Model
  {
    public function __construct()
    {
      parent::__construct();

      $this->load->library('email');
    }

    public function sendMail($from, $to, $subject, $message, $attachedFile=null)
    {
      $this->email->from($from);
      $this->email->to($to);
      $this->email->subject($subject);
      $this->email->message($message);
      // $this->email->cc(); //enviar copias
      // $this->email->bcc(); //enviar copias ocultas

      if($attachedFile != null){
        $this->email->attach($attachedFile);
      }
      if (!$this->email->send()) {
        echo "Error en el envio del mensaje" . $this->email->print_debugger;
      }
    }
  }
?>