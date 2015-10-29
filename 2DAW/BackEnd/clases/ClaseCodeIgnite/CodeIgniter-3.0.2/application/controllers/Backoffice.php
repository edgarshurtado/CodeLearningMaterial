<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Backoffice extends CI_Controller {

  function __construct() {
    parent::__construct();
    //Cargar el modelo
    $this->load->helper('url'); //Carga la función site_url().
    $this->load->database();
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
    // echo "$user $pass";

    $sql = "SELECT * FROM cg_users
            WHERE user_name='$user' AND user_password='$pass'";

    $query = $this->db->query($sql);

    if ($query->num_rows() == 1) {
      $this->load->view("backoffice/admin/pages/index.html");
    } else {
      $this->index();
    }
  }

  public function index()
  {
    //Cargamos vista loggin
    $view = "backoffice/login.php";
    $this->load->view($view);
  }
}
