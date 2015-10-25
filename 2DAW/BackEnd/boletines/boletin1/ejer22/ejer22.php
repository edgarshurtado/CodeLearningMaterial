<?php 
	$numero = $_POST['numero'];

	$primo = true;
	for ($i=2; $i < $numero && $primo; $i++) { 
		if($numero % $i == 0){
			$primo = false;
		}
	}
	if($primo){
		echo "$numero es primo";
	} else {
		echo "$numero no es primo";
	}
 ?>