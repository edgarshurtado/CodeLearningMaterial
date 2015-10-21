<?php 

	$size = $_POST['size'];
	$caracter = $_POST['caracter'];

	for ($i=0; $i < $size; $i++) { 
		for ($j=0; $j < $size; $j++) { 
			echo $caracter;
		}
		echo "<br />";
	}
?>