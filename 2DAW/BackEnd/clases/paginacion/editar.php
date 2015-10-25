<?php 
	$id = $_GET['id'];

	$con = mysqli_connect('localhost', 'root', '', "carreras");
	
	if (mysqli_connect_errno($con)) {
		echo 'FALLO AL CONECTAR A MYSQL' . mysqli_connect_error();
	}
	
	$sql = "SELECT * FROM participantes WHERE IdParticipante = $id";

	$result = mysqli_query($con, $sql);

	while ($row = mysqli_fetch_array($result)) {
		$apellidos = $row['Apellidos'];
		$nombre = $row['Nombre'];
		$poblacion = $row['Poblacion'];
		$club = $row['CLUB'];
	}
?>

<form name="Form1" method="POST" action="actualizar.php?id=<?php echo $id ?>">
	Apellidos: <input type="text" name="Apellidos" value="<?php echo $apellidos ?>">
	Nombre:	<input type="text" name="Nombre" value="<?php echo $nombre ?>">
	Poblacion: <input type="text" name="Poblacion" value="<?php echo $poblacion ?>">
	Club: <input type="text" name="CLUB" value="<?php echo $club ?>">

	<input type="submit" value="Actualizar">
</form>