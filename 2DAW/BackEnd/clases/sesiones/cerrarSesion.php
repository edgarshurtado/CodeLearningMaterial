<?php 
	session_start();
	unset($_SESSION['password']);
	unset($_SESSION['user']);
	//con session_destroy ya no haría falta hacer los
	//unset(variable)
	session_destroy();
 ?>