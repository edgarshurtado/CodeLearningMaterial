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

		public function retornarEdad(){
			return $this->edad;
		}
	}	

	$persona1 = new Persona();
	$persona1->fijarNombreEdad('Lucia', 20);

	$x = $persona1;
	echo 'Datos de la persona $persona1: ';
	echo $persona1->retornarNombre() . ' - ' . $persona1->retornarEdad() .
		'<br />';
	echo 'Datos de la persona $x: ';
	echo $x->retornarNombre() . ' - ' . $x->retornarEdad() .
		'<br />';

	$x->fijarNombreEdad('Ana', 25);

	echo 'Despues de modificar los datos: <br />';

	echo 'Datos de la persona $persona1: ';
	echo $persona1->retornarNombre() . ' - ' . $persona1->retornarEdad() .
		'<br />';
	echo 'Datos de la persona $x: ';
	echo $x->retornarNombre() . ' - ' . $x->retornarEdad() .
		'<br />';
	
	//Vamos a clonar

	$persona2 = clone($persona1);
	$persona1->fijarNombreEdad('Luis', 19);
	echo 'Despues de modificar los datos de $persona1: <br />';
	echo 'Datos de la persona $persona1: ';
	echo $persona1->retornarNombre() . ' - ' . $persona1->retornarEdad() .
		'<br />';
	echo 'Datos de la persona $persona2: ';
	echo $persona2->retornarNombre() . ' - ' . $persona2->retornarEdad() .
		'<br />';

?>