<?php
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
      echo "
      Nombre: $this->nombre <br>
      Edad: $this->edad <br>";
    }
  }

  class Empleado extends Persona
  {
    private $sueldo;
    public function setSueldo($sueldo=1000)
    {
      $this->sueldo = $sueldo;
    }
    function imprimirDatos()
    {
      parent::imprimirDatos();
      echo "sueldo: $this->sueldo";
    }
  }

  $pers = new Persona();
  $pers->setDatos("David", 25);
  $pers->imprimirDatos();

  $emp1 = new Empleado();
  $emp1->setDatos("Edgar", 26);
  $emp1->setSueldo(2000);

  $emp1->imprimirDatos();
?>

