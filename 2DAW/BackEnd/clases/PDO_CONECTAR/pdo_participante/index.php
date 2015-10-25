<?php
require_once 'participante.modelo.php';
require_once 'entidad.php';

//logica del programa (controlador)
$part = new Participante();
$modelo = new ParticipanteModelo();
?>
<html>
<head>
	<title></title>
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="" method="POST">
				<p>Nombre: <input type="text" name="Nombre"> <br></p>
				<p>Apellidos: <input type="text" name="Apellidos"> <br></p>
				<p>Poblacion: <input type="text" name="Poblacion"> <br></p>
				<p>CLUB: <input type="text" name="CLUB"> <br></p>
				<button type="button" class="btn btn-success">Guardar</button>
			</form>
		</div>

	</div>
	<table>
		<thead>
			<th>Nombre</th><th>Apellidos</th> <th>Poblacion</th> <th>Club</th>
		</thead>
		<tbody>
			<?php
			foreach ($modelo->listar() as $fila) {
				echo "<tr>
					<td>". $fila->__GET('Nombre') ."</td>
					<td>". $fila->__GET('Apellidos') ."</td>
					<td>". $fila->__GET('Poblacion') ."</td>
					<td>". $fila->__GET('CLUB') ."</td>
				</tr>";
			}
			?>
		</tbody>
	</table>
</body>
</html>