<?php 
	$size = $_POST['size'];
	$caracter = $_POST['caracter'];

	for ($i=$size; $i > 0; $i--) { 
		for ($j=0; $j < $i; $j++) { 
			echo $caracter;
		}
		echo "<br />";
	}
?>