<?php 
session_start();
$user = $_POST['user'];
$pass = $_POST['password'];

$_SESSION['user'] = $user;
$_SESSION['password'] = $pass;
 ?>

<html>
<head>
	<title>Login</title>
</head>
<body>
	Se almacenaron dos variables de sesion. 
	<br />
	<br />
	<a href="pagina3.php">Ir a la tercera pagina donde están las variables de sesion</a>
</body>
</html>