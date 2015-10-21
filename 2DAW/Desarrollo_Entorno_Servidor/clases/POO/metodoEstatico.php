<?php 
	class Cadena{
		public static function largo($cad){
			return strlen($cad);
		}

		public static function mayusculas($cad){
			return strtoupper($cad);
		}

		public static function minuscula($cad){
			return strtolower($cad);
		}
	}

	$c = 'Hola esto eS una Prueba PruEbecita';

	echo 'Cadena original: ' . $c .'<br />';
	echo 'Largo: ' . Cadena::largo($c) . '<br />';
	echo 'Toda en mayusculas ' . Cadena::mayusculas($c) . '<br />';
	echo 'Toda en minusculas ' . Cadena::minuscula($c) . '<br />';
?>