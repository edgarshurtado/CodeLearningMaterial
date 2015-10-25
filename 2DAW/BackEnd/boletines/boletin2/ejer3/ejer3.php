<?php 
	$cadena = $_POST['cadena'];
	$contador = 0;

	for ($i = 0; $i < strlen($cadena); $i++) {
		switch ($cadena{$i}) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				$contador++;
		}
	}

	echo "La cadena '$cadena' tiene " . $contador . " vocales";
	
?>