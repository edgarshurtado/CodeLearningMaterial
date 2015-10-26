<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Stores extends CI_Controller {

	function __construct() {
		parent::__construct();
		//Cargar el modelo
		$this->load->model('stores_model');
	}

  public function index()
  {
    echo "Hola, función de entrada del controlador";
    $titulo = "Este es el título de la primera página";
    $cuerpo = "Este es el cuerpo de la primera página";

    //Forma correcta de construir el array de datos
    $datos = array(
      'titulo'=> $titulo,
      'cuerpo'=>$cuerpo
    );
    //Forma menos profesional
    // $datos['titulo'] = $titulo;
    // $datos['cuerpo'] = $cuerpo;

    //Llamada del modelo
    $datos['stores'] = $this->stores_model->getAllStores();

    $this->load->view('vista', $datos);
  }
}
