<?php
  /**
  *
  */
  class Persona
  {
    private $nombre;
    private $edad;

    function setDatos($nombre, $edad)
    {
      $this->nombre = $nombre;
      $this->edad= $edad;
    }

    public function imprimirDatos()
    {
      return "
      Nombre: $this->nombre <br>
      Edad: $this->edad <br>";
    }

    function __clone()
    {
	    $this->edad++;
    }
  }

$pers1 = new Persona();
$pers1->setDatos('Edgar', 26);

$clon1 = clone $pers1;
echo $clon1->imprimirDatos() . "<br />";

$clon2 = clone $pers1;
echo $clon2->imprimirDatos() . "<br />";

$clon3 = clone $clon1;
echo $clon3->imprimirDatos() . "<br />";

?>
