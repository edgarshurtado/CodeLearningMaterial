<?php
	$numero = $_POST['numero'];
	$divisor = 2;
	echo "Los divisores son: 1, ";
	while($divisor < $numero){
		if($numero % $divisor == 0){
			echo $divisor.", ";
		}
		$divisor++;
	}
	echo $numero;
?>