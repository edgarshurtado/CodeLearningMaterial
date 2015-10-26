<?php
	class Cuadrado
	{
		private $lado;

		public function setLado($lado)
		{
			$this->lado = $lado;
		}

		public function getPerimetro()
		{
			return $this->lado*4;
		}

		public function getArea()
		{
			return $this->lado*$this->lado;
		}
	}

	$cuadr = new Cuadrado();
	$cuadr->setLado(10);

	$ref = &$cuadr;

	echo $ref->getPerimetro();
	echo "<br />";
	echo $ref->getArea();
?>
