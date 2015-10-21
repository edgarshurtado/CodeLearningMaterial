<?php 
	abstract class Trabajador {
		protected $nombre;
		protected $sueldo;

		public function __construct($nombre, $sueldo) {
			$this->nombre = $nombre;
			$this->sueldo = $sueldo;
		}

		public function getSueldo(){
			return $this->sueldo;
		}
	}	

	class Empleado extends Trabajador {

	}

	class Gerente extends Trabajador {

	}

	$vec[] = new Empleado('Lucia', 1200);
	$vec[] = new Empleado('Carlos', 2000);
	$vec[] = new Empleado('Anais', 2000);
	$vec[] = new Gerente('Jorge', 2500);
	$vec[] = new Gerente('Edgar', 2500);

	$suma1=0;
	$suma2=0;

	for ($i=0; $i < count($vec); $i++) { 
		if ($vec[$i] instanceof Empleado) {
			$suma1 += $vec[$i]->getSueldo();
		} elseif ($vec[$i] instanceof Gerente) {
			$suma2 += $vec[$i]->getSueldo();
		}
	}

	echo 'Sueldo empleados: ' . $suma1 . '<br />';
	echo 'Sueldo encargados: ' . $suma2;
?>