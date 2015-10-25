<?php 

/**
* 
*/
class CabeceraPagina
{
	private $titulo;
	private $ubicacion;
	private $colorFuente;
	private $colorFondo;

	function __construct($tit, $ubi='center', $cFuente="#FFFFFF", $cFondo="#000000")
	{
		$this->titulo = $tit;
		$this->ubicacion= $ubi;
		$this->colorFuente = $cFuente;
		$this->colorFondo= $cFondo;
	}

	public function dibujar()
	{
		echo '<div style="font-size:40px; text-align:' . $this->ubicacion . 
		'; color:'. $this->colorFuente . '; background-color:' . $this->colorFondo .
		'">';

		echo $this->titulo;
		echo '</div>';

	}
}

$cabecera1 = new CabeceraPagina("El Blog del Programador");
$cabecera1->dibujar();
echo "<br />";

$cabecera2 = new CabeceraPagina("El Blog del programador", "left");
$cabecera2->dibujar();
echo "<br />";
$cabecera3 = new CabeceraPagina("El Blog del programador", "right", "#FF0000");
$cabecera3->dibujar();
echo "<br />";
$cabecera4 = new CabeceraPagina("El Blog del programador", "center", "#FF0000", "#FFFF00");
$cabecera4->dibujar();
echo "<br />";


 ?>
