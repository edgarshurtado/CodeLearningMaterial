<?php
	class Calculator{
		static public function sumar($a, $b){
			return $a + $b;
		}
		static public function restar($a, $b){
			return $a - $b;
		}
		static public function multiplicar($a, $b){
			return $a * $b;
		}
		static public function dividir($a, $b){
			return $a / $b;
		}
	}

	echo Calculator::sumar(6, 2) . "<br />";
	echo Calculator::restar(6, 2) . "<br />";
	echo Calculator::multiplicar(6, 2) . "<br />";
	echo Calculator::dividir(7, 2) . "<br />";
?>
