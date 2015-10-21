<?php 
	/**
	* 
	*/
	class Tabla
	{
		private $filas;
		private $columnas;
		private $mat = array();

		public function __construct($fis, $cols)
		{
			$this->filas = $fis;
			$this->columnas = $cols;
		}

		private function inicioTabla ()
		{
			echo '<table border="1">';
		}

		private function fiTabla()
		{
			echo "</table>";
		}

		private function inicioFila()
		{
			echo "<tr>";
		}

		private function finFila()
		{
			echo "</tr>";
		}

		public function cargarDatos($fila, $columna, $valor)
		{
			$this->mat[$fila-1][$columna-1] = $valor;

		}

		private function mostrar($fi, $col)
		{
			echo "<td>".$this->mat[$fi][$col]."</td>";
		}

		public function dibujar()
		{
			$this->inicioTabla();
			for ($i=0; $i < $this->filas; $i++) { 
				$this->inicioFila();

				for ($j=0; $j < $this->columnas; $j++) { 
					$this->mostrar($i, $j);
				}
				$this->finFila();
			}
			$this->fiTabla();
		}
	}

	$tabla1 = new Tabla(2, 3);
	$tabla1->cargarDatos(1, 1, 1);
	$tabla1->cargarDatos(1, 2, 2);
	$tabla1->cargarDatos(1, 3, 3);
	$tabla1->cargarDatos(2, 1, 4);
	$tabla1->cargarDatos(2, 2, 5);
	$tabla1->cargarDatos(2, 3, 6);
	$tabla1->dibujar();
 ?>