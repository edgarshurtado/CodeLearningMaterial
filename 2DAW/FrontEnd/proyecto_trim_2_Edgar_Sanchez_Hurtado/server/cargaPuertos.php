<?php
header("Content-Type: application/xml");

$puertos["01"]["0014"] = "Alpe d'Huez";
$puertos["01"]["0029"] = "Stelvio";
$puertos["01"]["0493"] = "Passo di Gavia";
$puertos["02"]["0035"] = "Tourmalet";
$puertos["02"]["0066"] = "Envalira";
$puertos["02"]["0376"] = "Aubisque";
$puertos["03"]["0088"] = "Mont Ventoux";
$puertos["03"]["0040"] = "Angliru";
$puertos["03"]["0091"] = "Lagos de Covadonga";

$zona = trim($_POST["zona"]);
$seleccion = $puertos[$zona];

foreach($seleccion as $codigo => $nombre) {
  $elementos_xml[] = "<puerto><codigo>" .$codigo."</codigo><nombre>".$nombre."</nombre></puerto>";
}

echo "<puertos>\n".implode("\n", $elementos_xml)."</puertos>";

?>
