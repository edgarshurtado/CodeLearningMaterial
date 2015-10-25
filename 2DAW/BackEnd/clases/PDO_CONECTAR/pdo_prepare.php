<?php 
	$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
	$username = 'root';
	$passwd = '';

	try {
		$con = new PDO($dsn, $username, $passwd);
		$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); //Lanza una excepción si ocurre algún tipo de error
		$poblacion="GANDIA";
		$sql = "SELECT * FROM participantes WHERE Poblacion=? ORDER BY Apellidos";
		
		$stmt = $con->prepare($sql);	//el prepare tiene unas funciones de seguridad
										//evitando la inyección de código por url	
		$stmt->execute(array($poblacion));
		
		while ($datos=$stmt->fetch()) {
			echo "Apellidos: ". $datos['Apellidos']." ".$datos['Nombre'].$datos['CLUB']."<br />";
		}
	} catch (PDOException $e) {
		echo "Error: ". $e->getMessage();
	}

	$con = null;
?>