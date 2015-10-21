<?php 
	$numeros = array($_POST['numero1'],
					$_POST['numero2'],
					$_POST['numero3'],
					$_POST['numero4']);
	$media = ($numeros[0] + $numeros[1] + $numeros[2] + $numeros[3]) / 4;

	echo "El valor medio de los números " . 
		"$numeros[0], $numeros[1], $numeros[2], $numeros[3] " . 
		"es = $media";

?>