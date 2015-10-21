<?php 

abstract class Operacion{
	protected $valor1;
	protected $valor2;
	protected $resultado;

	public function __construct($v1, $v2){
		$this->valor1 = $v1;
		$this->valor2 = $v2;
	}

	public function imprimirResultado(){
		return $this->resultado;
	}

	public abstract function operar(); //El método abstracto no se implementa
										//eso nos obligará quién herede
}

class Suma extends Operacion{
	public function operar(){
		$this->resultado = $this->valor1 + $this->valor2; 
	}
}

class Resta extends Operacion{

	public function operar(){
		$this->resultado = $this->valor1 - $this->valor2; 
	}
}

$suma1 = new Suma(10, 10);
$suma1->operar();
echo 'El resultado de la suma es '. $suma1->imprimirResultado(). '<br />';

$resta1 = new Resta(20, 10);
$resta1->operar();
echo 'El resultado de la resta es ' . $resta1->imprimirResultado() . '<br />';
?>
