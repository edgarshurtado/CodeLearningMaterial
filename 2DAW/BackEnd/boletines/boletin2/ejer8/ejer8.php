<?php 
	function parseTiempo($delimitador, $cadena){
		$array = explode("$delimitador", $cadena);
		$res_array = [];

		foreach ($array as $valor) {
			$res_array[] = intval($valor);
		}

		return $res_array;
	}


	$fechaActual = getdate();
	$anyoActual = $fechaActual['year'];
	$mesActual = $fechaActual['mon'];
	$diaActual = $fechaActual['mday'];

	$fechaNacimiento = parseTiempo('/', $_POST['fechaNac']);
	$anyoNacimiento = $fechaNacimiento[2];
	$mesNacimiento = $fechaNacimiento[1];
	$diaNacimiento = $fechaNacimiento[0];

	$years = $anyoActual - $anyoNacimiento -1; //-1 por si en el año actual aún
												//no ha cumplido años.
	if ($mesActual > $mesNacimiento) {
		$years++;
	} elseif ($mesActual == $mesNacimiento && $diaActual >= $diaNacimiento) {
		$years++;
	}

	echo $years;
?>