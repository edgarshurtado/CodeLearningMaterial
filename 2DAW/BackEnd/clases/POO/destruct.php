<?php 
	class Banner{
		private $ancho;
		private $alto;
		private $mensaje;
		private $imagen;
		private $colorTexto;
		private $colorFondo;

		public function __construct($ancho, $alto, $mensaje){
			$this->ancho = $ancho;
			$this->alto = $alto;
			$this->mensaje = $mensaje;

			$this->imagen = imagecreate($this->ancho, $this->alto);

			$this->colorTexto = imagecolorallocate($this->imagen, 255, 255, 0);
			$this->colorFondo = imagecolorallocate($this->imagen, 255, 0, 0);
			imagefill($this->imagen, 0, 0, $this->colorFondo); //cordenadas desde donde
															//se empieza a pintar
		}

		public function dibujar(){
			imagestring($this->imagen, 5, 50, 10, $this->mensaje, $this->colorTexto);
			header("Content-type: image/png");
			imagepng($this->imagen);
		}

		public function __destruct() {
			imagedestroy($this->imagen);
		}
	}

$banner1 = new Banner(428, 45, 'sitema de ventas por mayor y menor');
$banner1->dibujar();
?> 