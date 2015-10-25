<?php
	$numero = $_POST['numero'];

	$comprobante = 2;

	$esPrimo = true;

	echo $numero;

	while($comprobante < $numero && $esPrimo){
		if($numero % $comprobante == 0){
			$esPrimo = false;
		}

		$comprobante++;
	}

	if($esPrimo){
		echo " es primo";
	} else {
		echo " no es primo";
	}
?>