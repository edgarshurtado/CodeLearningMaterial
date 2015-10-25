<?php 
	/**
	* 
	*/
	class Menu
	{
		private $enlaces = array();
		private $titulos = array();

		function cargarOpcion($en, $tit)
		{
			$this->enlaces[] = $en;

			$this->titulos[] = $tit;
}
		public function mostrar()
		{
			/*
			echo "Array de enlaces <br />";	
			print_r($this->enlaces);
			echo "<br />";
			print_r($this->titulos);
			*/

			for ($i=0; $i < count($this->enlaces); $i++) { 
				echo '<a href="'.$this->enlaces[$i].'">'.$this->titulos[$i].'</a> ';
			}
		}
	}

	$menu1 = new Menu();
	$menu1->cargarOpcion("http://www.google.com", "Buscador Google");
	$menu1->cargarOpcion("http://www.yahoo.com", "Buscador Yahoo");
	$menu1->cargarOpcion("http://www.msn.com", "MSN");

	$menu1->mostrar();
 ?>