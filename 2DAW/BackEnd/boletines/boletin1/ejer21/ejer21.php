<?php 
	$numero = $_POST['numero'];

	echo "1, ";
	for ($i=2; $i < $numero; $i++) { 
		if($numero % $i == 0){
			echo "$i, ";
		}
	}
	echo $numero;
 ?>