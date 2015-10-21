<?php 
	$id = $_GET['id'];

	$con = mysqli_connect('localhost', 'root', '', "Carreras");

	if (mysqli_connect_errno($con)) {
		echo 'FALLO AL CONECTAR A MYSQL' . mysqli_connect_error();
	}

	$sql = "DELETE FROM participantes WHERE IdParticipante='$id'";
	mysqli_query($con, $sql);

	mysqli_close($con);
?>