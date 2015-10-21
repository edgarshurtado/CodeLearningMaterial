<?php
	if(!empty($_POST['sexo'])){
		$sexo = $_REQUEST['sexo'];
		echo " El sexo es $sexo<br />";
	}

	if(!empty($_POST['edad'])){
		$edad = $_REQUEST['edad'];
		echo "La edad es $edad<br />";
	}

	if(!empty($_POST['Extras'])){
		$extras = $_POST['Extras'];
		foreach($extras as $extra){
			echo "$extra <br />";
		}
	}

	$aceptar = $_POST['Send']
?>