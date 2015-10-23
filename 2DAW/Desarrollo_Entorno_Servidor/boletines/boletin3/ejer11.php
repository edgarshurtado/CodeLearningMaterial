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
  $emp1->imprimirDatos();
  $emp1->imprimirSueldo();
  echo "<br><br>";
  $pers1 = new Persona();
  $pers1->setDatos("Edgar", 26);
  $pers1->imprimirDatos();

?>
