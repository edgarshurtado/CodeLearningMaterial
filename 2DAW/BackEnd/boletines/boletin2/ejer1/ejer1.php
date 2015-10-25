<?php 
	$num = $_POST['numero'];

	function esPrimo($numero)		
	{
		for ($i=2; $i < $numero/2; $i++) { 
			if ($numero % $i == 0) {
				return false;
			}
		}

		return true;
	}

	if (esPrimo($num)) {
		echo "El número es primo";
	} else {
		echo "El número NO es primo";
	}
?>