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
      echo "
      Nombre: $this->nombre <br>
      Edad: $this->edad <br>";
    }
  }

  /**
  *
  */
  class empleado extends persona
  {
    private $sueldo;
    public function setsueldo($sueldo=1000)
    {
      $this->sueldo = $sueldo;
    }
    function imprimirsueldo()
    {
      echo "sueldo: $this->sueldo";
    }
  }

  $emp1 = new empleado();
  $emp1->setdatos("edgar", 26);
  $emp1->setsueldo();
  $emp1->imprimirdatos();
  $emp1->imprimirsueldo();
  echo "<br><br>";
  $pers1 = new persona();
  $pers1->setdatos("edgar", 26);
  $pers1->imprimirDatos();

?>