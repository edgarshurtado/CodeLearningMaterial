<?php
$dsn ='mysql:host=localhost;dbname=tiendas_gandia';
$user = 'root';
$password = '';
$database = 'tiendas_gandia';

// EJEMPLO DE CONEXIÓN Y OBTENCIÓN DE DATOS
try {

    $conn = new PDO($dsn, $user, $password);
    $selectSQL = "SELECT * FROM participantes ORDER BY Dorsal";

    foreach ($conn->query($selectSQL) as $fila) {
        print_r($fila);
    }

} catch (Exception $e) {
    echo $e->getMessage();
    die();
}
// EJEMPLO DE INSERCIÓN
try {

    $insertSQL = "INSERT INTO participantes(Dorsal, Apellidos, Nombre, Poblacion)
    values(1001, 'server', 'Edgar', 'El Verger')";

    $stmt=$conn->prepare($insertSQL);
    $num_filas = $stmt->execute();

    if($num_filas > 0){
        echo "Inserción correcta";
    }
} catch (Exception $e) {

}
    $conn = null;


?>