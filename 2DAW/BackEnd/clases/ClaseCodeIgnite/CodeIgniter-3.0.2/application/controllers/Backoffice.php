<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Backoffice extends CI_Controller {

  function __construct() {
    parent::__construct();
    //Cargar el modelo
    $this->load->helper('url');
  }

  public function prueba()
  {
    echo "prueba backoffice";
  }

  public function validate_user()
  {
    // $user = $_POST['username'];
    // $pass = $_POST['password'];

    $user = $this->input->post('username');
    $pass = $this->input->post('password');
    echo "$user $pass";
  }

  public function index()
  {
    //Cargamos vista loggin
    $view = "backoffice/login.php";
    $this->load->view($view);
  }
}
