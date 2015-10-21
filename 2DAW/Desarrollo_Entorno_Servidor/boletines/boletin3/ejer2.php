<?php
  /**
  *
  */
  class Empleado
  {
    private $nombre;
    private $sueldo;
    function __construct($nombre, $sueldo)
    {
      $this->nombre = $nombre;
      $this->sueldo = $sueldo;
    }

    public function imprimir()
    {
      echo $this->nombre;
      if ($sueldo > 3000) {
        echo "Ha de pagar impuestos";
      } else {
        echo "No ha de pagar impuestos";
      }
    }
  }

  $emp1 = new Empleado("Edgar", 5000);
  $emp1->imprimir();
?>