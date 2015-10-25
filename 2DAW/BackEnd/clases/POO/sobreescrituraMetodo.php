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
		
		public function operar()
		{
			$this->resultado = $this->valor + $this->valor2;
		}

		public function imprimirResultado()
		{
			return "La suma de $this->valor + $this->valor2 es = $this->resultado";
		}
	}

	class Resta extends Operacion
	{
		
		public function operar()
		{
			$this->resultado = $this->valor - $this->valor2;
		}

		public function imprimirResultado()
		{
			return "La resta de $this->valor - $this->valor2 es = $this->resultado";
		}
	}

	$suma = new Suma(10, 20);
	$suma->operar();
	$suma = $suma->imprimirResultado();
	echo "El resultado de la suma es: $suma";

	echo "<br />";

	$resta = new Resta(10, 20);
	$resta->operar();
	$resta = $resta->imprimirResultado();
	echo "El resultado de la resta es: $resta";
 ?>