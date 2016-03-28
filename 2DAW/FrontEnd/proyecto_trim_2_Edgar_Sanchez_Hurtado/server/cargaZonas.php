<?php
header("Content-Type: application/xml");

$especialidades["01"] = "Alpes";
$especialidades["02"] = "Pirineos";
$especialidades["03"] = "Resto del Mundo";




foreach($especialidades as $codigo => $nombre) {
  $elementos_xml[] = "<zona>\n<codigo>$codigo</codigo>\n<nombre>".$nombre."</nombre>\n</zona>";
}

echo "<zonas>\n".implode("\n", $elementos_xml)."\n</zonas>"

?>
