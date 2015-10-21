<?php
require_once './participante.entidad.php';
require_once './participante.modelo.php';

$part = new Participante1();
$model = new ParticipanteModel();
if (isSet($_GET['action'])) {
    if($_GET['action'] == 'editar'){
        $part = $model->obtener('id');
    }
}
?>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <!-- Latest compiled and minified CSS & JS -->
        <link rel="stylesheet" media="screen" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="//code.jquery.com/jquery.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <style>
            * {
                font: normal 18px "Arial";
            }
            form {
                width: 90%;
                min-width: 300px;
                max-width: 600px;
                margin: auto;
            }
            input {
                display: block;
                height: 35px;
                width: 100%;
                border-radius: 5px;
            }
            input[type='submit']{
                margin-top: 20px;
                background: green;
            }
            input[type='submit']:hover{
                margin-top: 20px;
                background: greenyellow;
            }
            label {
                display: inline-block;
                padding: 10px 0;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div>
            <form name="form" method="POST">
                <label>Nombre:</label><input type="text" name="nombre" value="" />
                <label>Apellidos:</label><input type="text" name="apellidos" value="" />
                <label>Poblacion:</label><input type="text" name="poblacion" value="" />
                <label>Club:</label><input type="text" name="club" value="" />
                <input type="submit" value="Aceptar" />
            </form>
        </div>
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Poblacion</th>
                    <th>CLUB</th>
                </tr>
            </thead>
            <tbody>
                <?php
                    foreach ($model->listar() as $fila){
                        echo "<tr>
                        <td>" . $fila->__GET("Nombre") . "</td>
                        <td>" . $fila->__GET("Apellidos") . "</td>
                        <td>" . $fila->__GET("Poblacion") . "</td>
                        <td>" . $fila->__GET("CLUB") . "</td>
                        <td><a class='btn btn-warning' href='?action=editar&id=".
                        $fila->__GET('IdParticipante') ."'>Editar</a></td>
                        </tr>";
                    }
                ?>
            </tbody>
        </table>
    </body>
</html>
