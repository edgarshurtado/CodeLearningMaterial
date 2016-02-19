<?php
header("Content-Type: application/xml");

$especialidades["01"] = "Cochinillos";
$especialidades["02"] = "Otras carnes";
$especialidades["03"] = "Postres";
$especialidades["04"] = "Bebidas";




foreach($especialidades as $codigo => $nombre) {
  $elementos_xml[] = "<especialidad>\n<codigo>$codigo</codigo>\n<nombre>".$nombre."</nombre>\n</especialidad>";
}

echo "<especialidades>\n".implode("\n", $elementos_xml)."\n</especialidades>"

?>
