<?php
  /**
  *
  */
  abstract class Trabajador
  {
    protected $nombre;
    protected $sueldo;

    function __construct($nombre)
    {
      $this->nombre = $nombre;
    }

    abstract public function calcularSueldo();

    public function imprimirDatos()
    {
      echo "$this->nombre cobra $this->sueldo";
    }
  }

  /**
  *
  */
  class Empleado extends Trabajador
  {
    private $horasTrabajadas;
    private $valorHora = 3.50;

    function __construct($nombre, $horasTrabajadas){
      parent::__construct($nombre);
      $this->horasTrabajadas = $horasTrabajadas;
    }

    public function calcularSueldo()
    {
      $this->sueldo = $this->horasTrabajadas * $this->valorHora;
    }
  }

  /**
  *
  */
  class Gerente extends Trabajador
  {

    private $abono = 0.1;
    private $utilidadesEmpresa;
    function __construct($nombre, $utilidadesEmpresa) {
      parent::__construct($nombre);
      $this->utilidadesEmpresa = $utilidadesEmpresa;
    }

    public function calcularSueldo()
    {
      $this->sueldo = $this->utilidadesEmpresa * $this->abono;
    }
  }

  $empl = new Empleado("David", 160);
  $ger = new Gerente("Edgar", 10000);

  $empl-> calcularSueldo();
  $ger-> calcularSueldo();

  $empl->imprimirDatos();
  echo "<br />";
  $ger->imprimirDatos();
?>