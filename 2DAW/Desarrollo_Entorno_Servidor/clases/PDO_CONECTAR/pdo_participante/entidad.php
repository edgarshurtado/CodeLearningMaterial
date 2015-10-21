<?php 
    class Participante {
    	private $IdParticipante;
    	private $Nombre;
    	private $Apellidos;
    	private $Poblacion;
    	private $CLUB;

    	public function __GET($k)
    	{
    		return $this->$k;
    	}

    	public function __SET($k, $v)
    	{
    		$this->$k = $v;
    	}
    } 
?>