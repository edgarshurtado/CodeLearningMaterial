<?php
	$primero = 1;
	$segundo = 1;
	echo "$primero, $segundo, ";
	$posicionFibonacci = 2;
	while($posicionFibonacci <= 20){
		$nuevo = $primero + $segundo;
		echo "$nuevo, ";
		$primero = $segundo;
		$segundo = $nuevo;
		$posicionFibonacci++;
	}
?>