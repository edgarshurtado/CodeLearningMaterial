<?php
  /**
  *
  */
  class Persona
  {
    protected $nombre;
    protected $edad;

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
    function imprimirSueldo()
    {
      echo "Sueldo: $this->sueldo";
    }
  }
  $emp1 = new Empleado();
  $emp1->setDatos("Edgar", 26);
  $emp1->setSueldo();
?>