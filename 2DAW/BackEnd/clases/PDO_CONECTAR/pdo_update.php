<?php 
	$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
	$username = 'root';
	$passwd = '';
	try {
		$con = new PDO($dsn, $username, $passwd);
		$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "UPDATE participantes SET Poblacion=? WHERE Poblacion= ?";
		$poblacion = "ALZIRA";
		$poblacion2 = "alcira";

		$stmt = $con->prepare($sql);
		$filas = $stmt->execute(array($poblacion, $poblacion2));

		if($filas > 0){
			echo "Actualizacion correcta";
		} else {
			echo "Actualización erronea";
		}
	} catch (Exception $e) {
		
	}
?>