<?php 
	function parseTiempo($cadena){
		$array = explode(":", $cadena);
		$res_array = [];

		foreach ($array as $valor) {
			$res_array[] = intval($valor);
		}

		return $res_array;
	}

	function calcularRitmo($distancia, $tiempo){
		$ritmo = [];
		for($i = 0; $i < count($tiempo); $i++) {
			$ritmo[] = floor($tiempo[$i]/$distancia);
			if ($i + 1 < count($tiempo)) {
				$tiempo[$i+1] += ($tiempo[$i] % $distancia) * 60;
			}
		}

		return $ritmo;
	}

	function timeString($vectorTiempo){
		$vectorCadenas = [];
		foreach ($vectorTiempo as $valor) {
			if ($valor < 10) {
				$vectorCadenas[] = "0" . strval($valor);
			} else {
				$vectorCadenas[] = strval($valor);
			}
		}

		return "$vectorCadenas[0]:$vectorCadenas[1]:$vectorCadenas[2]";
	}

	$distancia = floatval($_POST['distancia']) / 1000;
	$tiempo = parseTiempo($_POST['tiempo']);
	$ritmo = calcularRitmo($distancia, $tiempo);

	echo "Distancia total de $distancia Km";
	echo "<br />";
	echo "Ritmo: " . timeString($ritmo) . " por Km."
?>