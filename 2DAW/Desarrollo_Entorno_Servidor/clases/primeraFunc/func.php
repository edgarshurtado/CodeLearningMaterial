<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function suma($a, $b){
    return $a + $b;
}

$a = 2;
$b = 3;

echo "La suma es ".suma($a, $b)."<br />";

//Pasando parámetros por referencia

function incremento(&$x) {
    $x = $x + 28;
}

echo "El valor antes de modificar es ".$a."<br />";

incremento($a);

echo "El valor después de modificar es ".$a."<br />";


function cuadradoPuk($valor, &$cuadrado, &$cubo){
    $cuadrado = pow($valor, 2);
    $cubo = pow($valor, 3);
}

$valor = 100;

cuadradoPuk($valor, $cuadrado, $cubo);

echo "el valor del cuadrado = $cuadrado y el cubo = $cubo";

//Poner un valor por defecto a un parámetro
function muestraNombre($titulo = "Sr."){
	echo "Estimado $titulo: <br>";
}

muestraNombre();
muestraNombre("Pepito");