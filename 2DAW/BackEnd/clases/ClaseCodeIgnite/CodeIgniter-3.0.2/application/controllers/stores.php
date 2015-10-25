<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Stores extends CI_Controller {

	function __construct() {
		parent::__construct();
		//Cargar el modelo
		$this->load->model('stores_model');
	}
}
