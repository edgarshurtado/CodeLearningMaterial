<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$medidas = array(10, 25, 15, 13);
$diasSemana = ["Lunes", "Martes", "Miércoles", "Jueves",
    "Viernes", "Sábado", "Domingo"];

echo "La longitud del array Medidas es ".count($medidas)."<br />";
for ($i = 0; $i < count($medidas); $i++){
    echo $medidas[$i]."<br />";
}

echo "La longitud del array Dias de la semana es ".count($diasSemana)."<br />";
for ($i = 0; $i < count($diasSemana); $i++){
    echo $diasSemana[$i]."<br />";
}

//array asociativa (Diccionario)

echo "Arrays asociativos <br />";

$alumnos = ["nombre" => "Pepe", "Apellidos" => "Garcia Ibañez"];

echo $alumnos["nombre"];

echo "<br /> Modelo 1 <br />";

foreach($alumnos as $dato){
    echo "Ficha alumno : $dato <br />";
}

echo "<br /> Modelo 2 <br />";

foreach($alumnos as $campo => $valor){
    echo "$campo : $valor <br />";
}