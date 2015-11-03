<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Backoffice extends CI_Controller {

  function __construct() {
    parent::__construct();
    //Cargar el modelo
    $this->load->helper('url'); //Carga la función site_url().
    $this->load->database();

    $this->load->library('session');
    $this->load->library('encrypt');

    //Cargar librería de CRUD
    $this->load->library('grocery_CRUD');
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
            WHERE user_name=?";

    $query = $this->db->query($sql, array($user));

    if ($query->num_rows() == 1) {
          $row = $query->row();
          $description = $row->user_description;
          $email = $row->user_email;
          $clave_cifrada = $row->user_password;

          //Decodificar la clave cifrada
          $clave_descodificada = $this->encrypt->decode($clave_cifrada);
          echo $clave_descodificada;

          if($pass == $clave_descodificada) {
          //Guardamos las variables de sesión
          $variables_sesion=array(
              'user_name' => $user,
              'user_description' => $description,
              'user_email' => $email);

          $this->session->set_userdata($variables_sesion);

          //Cargamos la página de administración
          $this->load->view("backoffice/admin/pages/index.php");
        } else {
          $this->index();
        }
    }
  }
  public function logout()
  {
      // $variables_sesion=array(
      //     'user_name' => "",
      //     'user_description' => "",
      //     'user_email' => "");

      // $this->session->unset_userdata($variables_sesion);
      // $this->index();
      $this->session->sess_destroy();
      $this->index();
  }

  public function usuarios()
  {
    $crud = new Grocery_CRUD();
    $crud->set_table('cg_users');

    //Introduccion de nuevos regristros
    //---------------------------------
    $crud->set_subject('usuarios'); // Permite aadir registros
    // Configurar campos obligatorios
    $crud->required_fields('user_name', 'user_email');
    $crud->change_field_type('user_password', 'password');
    $crud->callback_before_insert(array($this, 'encrypt_password_callback'));

    //Mostrar resultado
    //----------------
    $output = $crud->render();
    $this->load->view("backoffice/example", $output);
  }

  public function encrypt_password_callback($post_array)
  {
      $post_array['user_password'] = 
          $this->encrypt->encode($post_array['user_password']);

      return $post_array;
  }

  public function participantes()
  {
    // Esto es más corto porque le hemos puesto a la función el mismo nombre
    // que la tabla
    $output = $this->grocery_crud->render();
    $this->load->view("backoffice/example", $output);
  }

  public function tiendas()
  {
    $crud = new Grocery_CRUD();
    $crud->set_table('cg_store');
    $crud->columns( 'store_name', 'store_address', 'store_city', 
                    'store_state','store_logo', 'store_area_id');

    $crud->display_as('store_name', 'Nombre tienda');
    $crud->display_as('store_adress', 'Dirección tienda');

    $crud->set_field_upload('store_logo', 'assets/uploads/files');
    $crud->set_relation('store_area_id', 'cg_area_store', 'area_store_name');

    $output = $crud->render();
    $this->load->view("backoffice/example", $output);
  }

  public function verVariables()
  {
    echo "description:" . $this->session->userdata('user_description');
  }

  public function index()
  {
    //Cargamos vista loggin
    $view = "backoffice/login.php";
    $this->load->view($view);
  }
}
