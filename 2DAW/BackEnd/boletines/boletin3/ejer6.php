<?php
  /**
  *
  */
  class Tabla
  {
    private $rows;
    private $cols;
    private $matrix = array();
    function __construct($rows, $cols)
    {
      $this->rows = $rows;
      $this->cols = $cols;
      for ($i=0; $i < $rows; $i++) {
        for ($j=0; $j < $cols; $j++) {
          $this->matrix[$i][$j] = "<td>---</td>";
        }
      }
    }

    public function insertValue($texto, $fila, $columna,
                                $colorLetra = "black", $colorFondo="white")
    {
      $this->matrix[$fila][$columna] = "
        <td style=' background-color: $colorFondo;
                    color:$colorLetra;'>
          $texto
        </td>
      ";
    }

    public function printTable()
    {
      echo "<table border=1 style='text-align:center'>";
      for ($i=0; $i < $this->rows; $i++) {
        echo "<tr>";
        for ($j=0; $j < $this->cols; $j++) {
          echo $this->matrix[$i][$j];
        }
        echo "</tr>";
      }
      echo "</table>";
    }
  }

  $tabla1 = new Tabla(5, 5);
  $tabla1->insertValue("Hola Mundo", 2, 2);
  $tabla1->insertValue("Mensaje de prueba", 1, 0, "pink", "green");
  $tabla1->printTable();
?>