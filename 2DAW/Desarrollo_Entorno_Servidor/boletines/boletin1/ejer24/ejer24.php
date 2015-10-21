<?php 
	$nota = $_POST['nota'];
	$nota = round($nota);
	switch ($nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			echo "Estás suspendido";
			break;
		case 5:
			echo "Estás aprobado";
			break;
		case 6:
			echo "Bien";
			break;
		case 7:
			echo "Notable";
			break;
		case 8: 
		case 9:
		case 10:
			echo "Sobresaliente";

		default:
			echo "Nota no válida";
			break;
	}
 ?>