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
      // rellenamos la matriz con celdas vacías
      for ($i=0; $i < $rows; $i++) {
        for ($j=0; $j < $cols; $j++) {
          $this->matrix[$i][$j] = new Celda();
        }
      }
    }

    public function insertValue($texto, $fila, $columna,
                                $colorLetra = "black", $colorFondo="white")
    {
      $celda = $this->matrix[$fila][$columna];

      $celda->_SET("texto", $texto);
      $celda->_SET("colorFuente", $colorLetra);
      $celda->_SET("colorFondo", $colorFondo);
    }

    public function printTable()
    {
      echo "<table border=1 style='text-align:center'>";
      for ($i=0; $i < $this->rows; $i++) {
        echo "<tr>";
        for ($j=0; $j < $this->cols; $j++) {
          $this->matrix[$i][$j]->imprimir();
        }
        echo "</tr>";
      }
      echo "</table>";
    }
  }

  /**
  *
  */
  class Celda
  {
    private $texto;
    private $colorFuente;
    private $colorFondo;
    function __construct($texto="---", $colorFuente="black", $colorFondo="white")
    {
      $this->texto = $texto;
      $this->colorFuente = $colorFuente;
      $this->colorFondo = $colorFondo;
    }

    public function imprimir()
    {

      echo "
        <td style=' background-color: $this->colorFondo;
                    color:$this->colorFuente;'>
          $this->texto
        </td>
      ";
    }

    public function _SET($atributo, $valor)
    {
      $this->$atributo = $valor;
    }
  }

  $tabla1 = new Tabla(5, 5);
  $tabla1->insertValue("Hola Mundo", 2, 2);
  $tabla1->insertValue("Mensaje de prueba", 1, 0, "pink", "green");
  $tabla1->printTable();
?>