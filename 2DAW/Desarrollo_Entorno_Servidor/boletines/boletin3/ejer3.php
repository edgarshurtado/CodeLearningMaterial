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

    public function imprimirVertical()
    {
      for ($i=0; $i < count($this->opciones); $i++) {
        echo $i + 1 . " " . $this->opciones[$i] . "<br />";
      }
    }

    public function imprimirHorizontal()
    {
      for ($i=0; $i < count($this->opciones); $i++) {
        echo $i + 1 . " " . $this->opciones[$i] . " ";
      }
    }
  }

  $menu1 = new Menu(array("Abrir", "Cerrar", "Guardar"));
  $menu1->imprimirVertical();
  echo "<br />";
  $menu1->imprimirHorizontal();
?>