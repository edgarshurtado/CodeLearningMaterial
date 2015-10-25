<?php 
	$nombre = $_POST['nombre'];
	$descripcion = $_POST['descripcion'];

	$fichero = fopen("datos.txt", "a") or die ("No se pudo abrir");

	fputs($fichero, $nombre . "\n");
	fputs($fichero, $descripcion . "\n");
	fclose($fichero);

 ?>

<a href="pagina3.php">Leer fichero</a>
