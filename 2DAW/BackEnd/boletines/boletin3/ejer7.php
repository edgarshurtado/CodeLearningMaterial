<?php
  /**
  *
  */
  class Menu
  {
    private $opciones = array();
    function __construct($opciones)
    {
      $this->opciones = $opciones;
    }

    private function imprimirVertical()
    {
      for ($i=0; $i < count($this->opciones); $i++) {
        echo $i + 1 . " " . $this->opciones[$i] . "<br />";
      }
    }

    private function imprimirHorizontal()
    {
      for ($i=0; $i < count($this->opciones); $i++) {
        echo $i + 1 . " " . $this->opciones[$i] . " ";
      }
    }

    public function imprimir($modo)
    {
      switch ($modo) {
        case 'vertical':
          $this->imprimirVertical();
          break;
        case 'horizontal':
          $this->imprimirHorizontal();
          break;

        default:
          echo "Modo no admitido";
          break;
      }
    }
  }

  $menu1 = new Menu(array("Abrir", "Cerrar", "Guardar"));
  $menu1->imprimir("vertical");
  echo "<br />";
  $menu1->imprimir("horizontal");
?>