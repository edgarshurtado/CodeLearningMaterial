<?php 
// Una clase final significa que no puede ser heredar, y un método final
//significa que no se puede sobreescribir

abstract class Operacion{
	protected $valor1;
	protected $valor2;
	protected $resultado;

	public function __construct($v1, $v2){
		$this->valor1 = $v1;
		$this->valor2 = $v2;
	}

	public final function imprimirResultado(){
		return $this->resultado;
	}
}

final class Suma extends Operacion{
	private $titulo; 

	public function __construct($v1, $v2, $tit){
		parent::__construct($v1, $v2); //Llamada al constructor del padre
		$this->titulo = $tit;
	}

	public function operar(){
		echo $this->titulo . ' ';
		echo $this->valor1 . ' + ' . $this->valor2 . ' es ';
		$this->resultado = $this->valor1 + $this->valor2; 
	}
}


class Resta extends Operacion{

	private $titulo; 

	public function __construct($v1, $v2, $tit){
		parent::__construct($v1, $v2); //Llamada al constructor del padre
		$this->titulo = $tit;
	}
	public function operar(){
		echo $this->titulo . ' ';
		echo $this->valor1 . ' - ' . $this->valor2 . ' es ';
		$this->resultado = $this->valor1 - $this->valor2; 
	}
}

$suma1 = new Suma(10, 10, 'suma');
$suma1->operar();
echo $suma1->imprimirResultado(). '<br />';

$resta1 = new Resta(20, 10, 'resta');
$resta1->operar();
echo $resta1->imprimirResultado() . '<br />';
?>
