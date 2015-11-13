<?php

$host ='localhost';
$user = 'root';
$password = '';
$database = 'tiendas_gandia';

$con = mysqli_connect($host, $user, $password, $database);

if(mysqli_errno($con)){
    echo "fallo la connexión: " . mysqli_connect_errno();
} else {
    echo "conexión correcta";
}


$mysqli = new mysqli($host, $user, $password, $database);

if ($mysqli->connect_errno) {
    echo "Conexión fallida con objetos";

} else {
    echo "Conexión exitosa con objetos";
}

$insertSQL = "INSERT INTO participantes(Dorsal, Apellidos, Nombre, Poblacion)
values(1001, 'server', 'Edgar', 'El Verger')";

// Inserción por método procedimental
// if(!mysqli_query($con, $insertSQL)){
//     die('Error al insertar' . mysqli_error($con)); //El programa acaba aquí ya
//                                                     // no continúa
// } else {
//     echo "Un registro añadido";
// }

// Sacar resultados por método procedimental
$selectSQL = "SELECT * FROM participantes ORDER BY Dorsal";
// $result = mysqli_query($con, $selectSQL);
// print_r($result);

// while ($fila = mysqli_fetch_array($result)) {
//     echo "Apellidos: " . $fila["Apellidos"];
//     echo "Nombre" . $fila["Nombre"];
//     echo "Dorsal" . $fila["Dorsal"];
//     echo "Poblacion" . $fila["Poblacion"];
//     echo "<br />";
// }

// Inserción por método de OO
// $insertSQL = "INSERT INTO participantes(Dorsal, Apellidos, Nombre, Poblacion)
// values(2001, 'server', 'Edgar', 'El Verger')";

// if(!$mysqli->query($insertSQL)) {
//     echo "No s'ha creat ";
// } else {
//     echo "otro añadido mediante objeto";
// }

if ($result = $mysqli->query($selectSQL)) {
    // FETCH POR ARRAY.
    // while($fila = $result->fetch_array()){
    //     echo "Apellidos: " . $fila["Apellidos"];
    //     echo "Nombre" . $fila["Nombre"];
    //     echo "Dorsal" . $fila["Dorsal"];
    //     echo "Poblacion" . $fila["Poblacion"];
    //     echo "<br />";
    // }

    // FETCH POR OBJETOS
    while ($obj = $result->fetch_object()) {
             echo "Apellidos: " . $obj->Apellidos;
        echo "Nombre" . $obj->Nombre;
        echo "Dorsal" . $obj->Dorsal;
        echo "Poblacion" . $obj->Poblacion;
        echo "<br />";
    }
}


mysqli_close($con);


?>