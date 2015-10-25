<?php 
$id = $_GET['id'];

$apellidos = $_POST['Apellidos'];
$nombre = $_POST['Nombre'];
$poblacion = $_POST['Poblacion'];
$club = $_POST['CLUB'];

$con = mysqli_connect('localhost', 'root', '', 'carreras');

if (mysqli_connect_errno($con)) {
	echo 'FALLO AL CONECTAR';
}

$sql = "UPDATE participantes SET Apellidos='$apellidos', Nombre='$nombre', Poblacion='$poblacion', Club='$club' WHERE IdParticipante='$id'";

mysqli_query($con, $sql);

mysqli_close($con);
?>