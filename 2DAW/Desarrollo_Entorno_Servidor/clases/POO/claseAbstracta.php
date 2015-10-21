<?php /**
* 
*/
abstract class Operacion
{
	
	protected $valor1;
	protected $valor2;
	protected $resultado;

	function __construct($v1, $v2)
	{
		$this->valor1 = $v1;
		$this->valor2 = $v2;
	}

	public function imprimirResultado(){
		return $this->resultado . '<br />';
	}
}

class Suma extends Operacion {
	public function operar(){
		$this->resultado = $this->valor1 + $this->valor2;
	}
}

class Resta extends Operacion {

	public function operar(){
		$this->resultado = $this->valor1 - $this->valor2;
	}
}

$suma1 = new Suma(10, 10);
$suma1->operar();
echo 'El resultado de la suma es ' . $suma1->imprimirResultado();
	
$resta1 = new Resta(10, 10);
$resta1->operar();
echo 'El resultado de la resta es ' . $resta1->imprimirResultado();

//Instancia de la clase abstracta no funciona

//$operacion1 = new Operacion(10, 10);
//$operacion1->imprimirResultado();
?> 