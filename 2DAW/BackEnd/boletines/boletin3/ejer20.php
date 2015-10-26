<?php
  /**
  *
  */
  class Trabajador
  {
    private $nombre;
    private $sueldo;

    function __construct($nombre, $sueldo=1000)
    {
      $this->nombre = $nombre;
      $this->sueldo = $sueldo;
    }

    public function getNombre()
    {
	return "$this->nombre";
    }

    public function getSueldo()
    {
	   return  $this->sueldo;
    }
  }

  class Empleado extends Trabajador
  {
  }

  class Gerente extends Trabajador
  {
  }

  $trabajadores = [new Empleado("Edgar"),
	        new Empleado("Cristina", 10000),
		new Empleado("David"),
		new Gerente("David", 10000),
		new Gerente("Luis"),
		];

  $maxGerenteIndex = 0;
  $maxGerenteSueldo = 0;
  for($i=0; $i<count($trabajadores); $i++){
	if($trabajadores[$i] instanceof Gerente && $trabajadores[$i]->getSueldo() > $maxGerenteSueldo){
		$maxGerenteIndex = $i;	
		$maxGerenteSueldo = $trabajadores[$i]->getSueldo();	
	}
  }

  $maxGerente = $trabajadores[$maxGerenteIndex];
  echo $maxGerente->getNombre() . "<br />";
  echo $maxGerente->getSueldo() . "<br />";
?>
