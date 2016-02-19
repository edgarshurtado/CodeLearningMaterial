<?php
header("Content-Type: application/xml");

$platos["01"]["0014"] = "Cochinillo Segoviano";
$platos["01"]["0029"] = "Cochinillo al vino";
$platos["01"]["0493"] = "Cochinillo a las hierbas";
$platos["02"]["0035"] = "Estofado de Jabalí";
$platos["02"]["0066"] = "Ciervo a la brasa";
$platos["02"]["0376"] = "Cabritillo al Cabrales";
$platos["03"]["0088"] = "Tarta de manzana";
$platos["03"]["0040"] = "Flan";
$platos["03"]["0091"] = "Arroz con leche";
$platos["04"]["0105"] = "Ribera del Duero";
$platos["04"]["0112"] = "Rioja";
$platos["04"]["0133"] = "Valdepeñas";
$platos["04"]["0148"] = "Somontano";

$especialidad = trim($_POST["especialidad"]);
$seleccion = $platos[$especialidad];

foreach($seleccion as $codigo => $nombre) {
  $elementos_xml[] = "<plato><codigo>$codigo</codigo><nombre>".$nombre."</nombre></plato>";
}

echo "<platos>\n".implode("\n", $elementos_xml)."</platos>";

?>