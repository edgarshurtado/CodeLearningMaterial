<?php 
	session_start();
?>

<html>
<head>
	<title></title>
</head>
<body>
	<?php echo "El usuario es " . $_SESSION['user'] ?>
	<a href="cerrarSesion.php">Cerrar Sesión</a>
</body>
</html>