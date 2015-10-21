<html>
<head>
	<title></title>
</head>
<body>
	<?php 
		$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
		$username = 'root';
		$passwd = '';

		try{
			$mbd = new PDO($dsn, $username, $passwd);
			$mbd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); //Lanza una excepción si ocurre algún tipo de error
			foreach ($mbd->query('SELECT * FROM participantes ORDER BY apellidos') as $fila) {
				//print_r($fila);
				echo "Apellidos: ".$fila['Apellidos']."<br />";
			}
		}catch(Exception $ex){
			echo 'Error: '. $ex->getMessage();
		}

		//cerrar conexión

		$mbd= null;
	?>
</body>
</html>