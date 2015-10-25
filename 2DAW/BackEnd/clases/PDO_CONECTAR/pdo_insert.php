<?php 
	$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
	$username = 'root';
	$passwd = '';
	try {
		$con = new PDO($dsn, $username, $passwd);
		$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "INSERT INTO participantes(Nombre, Apellidos, Poblacion, CLUB)
				VALUES (?,?,?,?)";

		$nombre="Lucia";
		$apellidos="AAWhatEver";
		$poblacion="Whereever";
		$club="Los pillaos";

		$stmt = $con->prepare($sql);
		$filas=$stmt->execute(array($nombre,$apellidos,$poblacion,$club));
			//Devuelve el nº de filas afectadas

		if($filas >= 1){
			echo "Insercion correcta";
		} else {
			echo "Insercion incorrecta";
		}
		
	} catch (Exception $e) {
		
	}
?>