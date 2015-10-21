<?php 
	$arrayNumStr = explode("," ,$_POST['array']);
	$arrayNum = [];
	foreach ($arrayNumStr as $string) {
		$arrayNum[] = strval($string);
	}

	echo "El mayor valor es: " . max($arrayNum);
?>