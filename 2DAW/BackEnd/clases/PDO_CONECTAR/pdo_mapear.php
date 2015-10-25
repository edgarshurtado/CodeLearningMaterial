<?php 
	/**
	* 
	*/
	class Participantes
	{
		//Los nombres deben de coincidir con los de las columnas en la 
		//base de datos
		private $Nombre;
		private $Apellidos;
		private $Poblacion;
		private $CLUB;

		public function ficha()
		{
			return $this->Nombre." ".$this->Apellidos." ".$this->Poblacion." ".$this->CLUB;
		}
	}

	$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
	$username = 'root';
	$passwd = '';

	try {
		$con = new PDO($dsn, $username, $passwd);
		$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
		$sql = "SELECT Nombre, Apellidos, Poblacion, CLUB FROM participantes
			ORDER BY Apellidos";
		$stmt = $con->prepare($sql);
		$stmt->execute();
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'Participantes');

		while($participante = $stmt->fetch()){
			echo $participante->ficha() . "<br />";
		}
	} catch (Exception $e) {
		
	}

	$con = null;
?>