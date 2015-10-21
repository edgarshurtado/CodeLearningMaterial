<html>
<head>
	<title></title>
</head>
<body>
	<?php 
	if (isset($_GET['pagina'])) {
		$pagina = $_GET['pagina'];
	} else {
		$pagina = 1;
	}

	//Variables para la paginación
	$TAMANY_PAGINA = 25; //Cantidad máxima de elementos por página
	$registro_inicio = ($pagina - 1) * $TAMANY_PAGINA; //punto de inicio

	//Conexion con la base de datos
	$con = mysqli_connect('localhost','root', '' , 'Carreras');

	if (mysqli_connect_errno($con)) {
		echo mysqli_connect_error();
	} else {
		$sql = "SELECT * FROM participantes ORDER BY apellidos " .
			"LIMIT $registro_inicio, $TAMANY_PAGINA";
	
		$result = mysqli_query($con, $sql);

		//Obtenemos el numero de registros
//
//		$sql2 = "SELECT * FROM participantes";
//		$totalFilas = mysqli_query($con, $sql2);
//		$numTotalRegistros = mysqli_num_rows($totalFilas);

		//Con un count
		$sql2 = "SELECT count(*) as result FROM participantes";
		$result2 = mysqli_query($con, $sql2);
		
		foreach ($result2 as $res) {
			$numTotalRegistros = $res['result'];
		}
		echo $numTotalRegistros . "<br />";

		//CALCULAR EL TOTAL DE PÁGINAS

		$totalPaginas = ceil($numTotalRegistros/$TAMANY_PAGINA);
		echo "Número de páginas = " . $totalPaginas;
		echo "<br />";
		echo "<a href='insertar.php'>Insertar</a>";
		echo "<table border=1>";	
		echo "<tr>" .
			"<td>Apellidos</td>" .
			"<td>Nombre</td>" .
			"<td>Sexo</td>" .
			"<td>DNI</td>" .
			"<td>FechaNac</td>" .
			"<td>Operaciones</td>" .
			"</tr>";

		foreach ($result as $fila) {
			echo "<tr>";
			
			echo "<td>";
			echo $fila["Apellidos"];
			echo "</td>";

			echo "<td>";
			echo $fila["Nombre"];
			echo "</td>";

			echo "<td>";
			echo $fila["Sexo"];
			echo "</td>";

			echo "<td>";
			echo $fila["DNI"];
			echo "</td>";

			echo "<td>";
			echo $fila["FechaNac"];
			echo "</td>";

			echo "<td>";
			echo "<a href='borrar.php?id=". $fila["IdParticipante"] . "'>Borrar</a>";
			echo "<a href='editar.php?id=". $fila["IdParticipante"] . "'>Editar</a>";
			echo "</td>";			

			echo "</tr>";
		}
		echo "</table>";


		echo "<br />";

		for ($i= 1; $i <= $totalPaginas; $i++) { 
			echo "<a href='paginacion.php?pagina=$i'>$i </a>";
		}

	}
	mysqli_close($con); //cierre de la base de datos
	


	?>
</body>
</html>