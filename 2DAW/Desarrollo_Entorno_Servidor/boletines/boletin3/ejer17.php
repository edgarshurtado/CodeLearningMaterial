<?php
	class Persona {
		private $nombre;
		private $edad;

		public final function cargarDatos($nombre, $edad){
			$this->nombre = $nombre;
			$this->edad = $edad;
		}

		public function imprimir(){
			echo "Nombre: $this->nombre  Edad: $this->edad";
		}
	}

	final class Empleado extends Persona {
		private $sueldo;

		public function cargarSueldo($sueldo){
			$this->sueldo = $sueldo;
		}		

		public function imprimirSueldo(){
			echo "Sueldo: $this->sueldo";
		}
	}

  $emp1 = new Empleado();
  $emp1->cargarDatos("Edgar", 26);
  echo "<br />";
  $emp1->cargarSueldo(2000);
  $emp1->imprimir();
  echo "<br />";
  $emp1->imprimirSueldo();

  echo "<br /><br />";
  $pers = new Persona();
  $pers->cargarDatos("David", 25);
  $pers->imprimir();
?>
