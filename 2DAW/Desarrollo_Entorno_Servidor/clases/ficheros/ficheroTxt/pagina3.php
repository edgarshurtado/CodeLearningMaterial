<?php 
	$fichero = fopen("datos.txt", "r");

	while(!feof($fichero)){ //Mientras no sea final de fichero
		$linea = fgets($fichero); // lee una linea

		$lineaSalto = nl2br($linea); //transforma los \n del fichero
									 //en <br /> para que salgan los
									 //saltos de línea en el html

		echo $lineaSalto;
	}
	fclose($fichero);
 ?>