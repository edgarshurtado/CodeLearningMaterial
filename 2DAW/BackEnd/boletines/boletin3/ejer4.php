<?php
  /**
  *
  */
  class CabeceraPagina
  {
    private $colorFuente;
    private $colorFondo;
    private $posicionTexto;
    private $texto;
    function __construct($texto, $colorFuente, $colorFondo, $posicionTexto)
    {
      $this->colorFuente = $colorFuente;
      $this->colorFondo = $colorFondo;
      $this->posicionTexto= $posicionTexto;
      $this->texto = $texto;
    }

    public function imprimir()
    {
      echo "
        <h2 style='color: $this->colorFuente; text-align: $this->posicionTexto;
        background-color: $this->colorFondo'>
          $this->texto
        </h2>
      ";
    }
  }

  $cabecera1 = new CabeceraPagina("Hola Mundo", "red", "black", "center");
  $cabecera1->imprimir();
?>