<?php 
	/**
	* 
	*/
	class CabeceraPagina
	{
		private $titulo;
		private $ubicacion;

		function __construct($tit, $ubicacion) //Inicializa los atributos
		{
			$this->titulo = $tit;
			$this->ubicacion = $ubicacion;
		}

		public function dibujar()
		{
			echo '<div style="font-size:40px; text-align:'.$this->ubicacion.'">';
			echo $this->titulo;
			echo '</div>';
		}
	}

	$cabecera = new CabeceraPagina("El blog del programador", "center");
	$cabecera->dibujar();
 ?>