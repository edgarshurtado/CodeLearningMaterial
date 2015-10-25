<?php 
	class Persona{
		private $nombre;
		private $edad;

		public function fijarNombreEdad($nombre, $edad) {
			$this->nombre = $nombre;
			$this->edad = $edad;
		}

		public function retornarNombre(){
			return $this->nombre;
		}

		public function __clone(){
			//$this->edad = 0;
			die('No esta permitido clonar objetos de esta clase'); //por si no
															//queremos permitir que se
															//clone una clase
		}

		public function retornarEdad(){
			return $this->edad;
		}
	}

	$persona1 = new Persona();
	$persona1->fijarNombreEdad('Juan', 19);

	echo 'Datos de la persona $persona1: ';
	echo $persona1->retornarNombre() . ' - ' . $persona1->retornarEdad() .
		'<br />';

	$persona2 = clone($persona1);
	echo 'Datos de la persona $persona2: ';
	echo $persona2->retornarNombre() . ' - ' . $persona2->retornarEdad() .
		'<br />';

?>