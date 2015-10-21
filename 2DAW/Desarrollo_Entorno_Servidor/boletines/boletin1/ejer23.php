<?php 
	$ultimo = 1;
	$penultimo = 1;

	echo "$ultimo, $penultimo, ";

	for ($i=3; $i < 20; $i++) { 
		$nuevo = $ultimo + $penultimo;

		echo "$nuevo, ";

		$penultimo = $ultimo;
		$ultimo = $nuevo;
	}
	echo ($ultimo + $penultimo);
 ?>