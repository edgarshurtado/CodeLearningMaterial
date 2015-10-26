<?php
	class Prueba {
		function __construct(){
			echo "Se ha creado un objeto de prueba";
		}

		function __destruct(){
			echo "Se ha destruido un objeto de prueba";
		}
	}

$prueba1 = new Prueba();
echo "<br />";
?>
