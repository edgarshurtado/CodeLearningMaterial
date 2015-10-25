<?php 

	class Operacion
	{
		protected $valor;    //protected permite ver a los que heredan
		protected $valor2;
		protected $resultado;

		function __construct($v1, $v2)
		{
			$this->valor = $v1;
			$this->valor2 = $v2;
		}

		public function imprimirResultado()
		{
			return $this->resultado . "<br />";
		}
	}

	/**
	* 
	*/
	class Suma extends Operacion
	{
		protected $titulo;
		
		public function __construct($v1, $v2, $tit)
		{
			parent::__construct($v1, $v2);
			$this->titulo = $tit;
		}
		public function operar()
		{
			echo $this->titulo;
			echo $this->valor . ' + ' . $this->valor2 . ' = ';
			$this->resultado = $this->valor + $this->valor2;
		}
	}


	$suma = new Suma(10, 20, "<h2>Suma</h2>");
	$suma->operar();
	echo $suma->imprimirResultado()
?>