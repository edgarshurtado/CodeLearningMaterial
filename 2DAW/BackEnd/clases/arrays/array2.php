<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$fecha = date('d/m/y');
echo $fecha."<br />";
$fecha2 = explode("/", $fecha);
var_dump($fecha2); echo "<br />";
print_r($fecha2);

$dia = $fecha2[0];
$mes = $fecha2[1];
$anno = $fecha2[2];

echo "<br />dia: $dia mes: $mes año $anno <br />";

$hora = date("h:i:s");
echo $hora."<br />";

$h = explode(":", $hora);

$hora = $h[0];
$min = $h[1];


