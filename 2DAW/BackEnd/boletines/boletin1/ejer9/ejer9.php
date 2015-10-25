<?php
	$primera = $_POST['a'];
	$segunda = $_POST['b'];
	$alumno = $_POST['alumno'];
	$alumno = explode(" ", $alumno);
	if($primera > 0 && $segunda < $primera){
		echo $alumno[0];
	}else if($primera > 0 && $segunda >= $primera){
		echo $alumno[1].' '.$alumno[2];
	}else if($primera < 0){
		echo $alumno[0].' '.$alumno[1].' '.$alumno[2];
	}
?>
