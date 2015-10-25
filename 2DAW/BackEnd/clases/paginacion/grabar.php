<?php 

$apellidos = $_POST['Apellidos'];
$nombre = $_POST['Nombre'];
$poblacion = $_POST['Poblacion'];
$club = $_POST['CLUB'];

$con = mysqli_connect('localhost', 'root', '', 'carreras');

if (mysqli_connect_errno($con)) {
	echo 'FALLO AL CONECTAR';
}


$sql="INSERT INTO participantes (Apellidos, Nombre, Poblacion, Club) VALUES ('$apellidos', '$nombre', '$poblacion', '$club')";

if (!mysqli_query($con, $sql)) {
	die('error:' . mysqli_error($con));
}else {
	echo "Registro añadido con éxito";
}

mysqli_close($con);

?>

