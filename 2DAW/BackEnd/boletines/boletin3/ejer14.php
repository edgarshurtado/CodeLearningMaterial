<?php
  class Persona
  {
    private $nombre;
    private $edad;

    function __construct($nombre, $edad)
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

    public function __construct($nombre, $edad, $sueldo=1000)
    {
      parent::__construct($nombre, $edad);
      $this->sueldo = $sueldo;
    }
    function imprimirDatos()
    {
      parent::imprimirDatos();
      echo "sueldo: $this->sueldo";
    }
  }

  $pers = new Persona("David", 25);
  $pers->imprimirDatos();

  $emp1 = new Empleado("Edgar", 26, 2000);
  $emp1->imprimirDatos();
?>