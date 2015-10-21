<?php
class ParticipanteModelo {
   private $pdo;

   function __construct() {
      try {
    			$dsn = 'mysql: host=localhost; dbname=carreras'; //tipo de base de datos
                $username = 'root';
                $passwd = '';
                $this->pdo = new PDO($dsn, $username, $passwd);
                $con = new PDO($dsn, $username, $passwd);
                $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            } catch (Exception $e) {
    			die($e->getMessage()); //Acaba el programa
    		}
    	}

    	public function eliminar($id)
    	{
    		try {
    			$sql="DELETE from participantes WHERE IdParticipante=?";
    			$stm = $this->pdo->prepare($sql);
    			$stm->execute(array($id));

    		} catch (Exception $e) {
    			die($e->getMessage());
    		}
    	}

    	public function obtener($id)
    	{
    		try {
    			$sql = "SELECT * FROM participantes WHERE idParticipante=?"
    			$stm = $this->pdo->prepare($sql);
    			$stm->execute(array($id));
    			$fila = $stm->fetch(PDO::FETCH_OBJ);

    			$participante1=new Participante();
    			$participante1->__SET('IdParticipante', $fila->IdParticipante);
    			$participante1->__SET('Nombre', $fila->Nombre);
    			$participante1->__SET('Apellidos', $fila->Apellidos);
    			$participante1->__SET('Poblacion', $fila->Poblacion);
    			$participante1->__SET('CLUB', $fila->CLUB);

    		} catch (Exception $e) {

    		}
    	}

    	public function actualizar(Participante $data)
    	{
         try {
            $sql="UPDATE participantes
            SET Nombre =?,
            Apellidos=?,
            Poblacion=?,
            CLUB=?
            WHERE IdParticipante=?";
            $this->pdo->prepare($sql)
            ->execute(array($data->__GET('Nombre'),
               $data->__GET('Apellidos'),
               $data->__GET('Poblacion'),
               $data->__GET('CLUB'),
               $data->__GET('IdParticipante')));
        } catch (Exception $e) {

        }
    }

    public function insertar(Participante $data)
    {
      try {
         $sql="INSERT INTO participantes(Nombre, Apellidos, Poblacion, CLUB)
         VALUES (?,?,?,?)";
         $this->pdo->prepare($sql)
         ->execute();
     } catch (Exception $e) {

     }
 }

 public function listar (){
        try {
            $result = array();
            $sql = "SELECT IdParticipante, Nombre, Apellidos, Poblacion, CLUB"
            . " FROM participantes ORDER BY Apellidos";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute();

            foreach ($stmt->fetchAll(PDO::FETCH_OBJ) as $fila) {
                $part = new Participante1();
                $part->__SET("IdParticipante", $fila->IdParticipante);
                $part->__SET("Nombre", $fila->Nombre);
                $part->__SET("Apellidos", $fila->Apellidos);
                $part->__SET("Poblacion", $fila->Poblacion);
                $part->__SET("CLUB", $fila->CLUB);
                $result[] = $part;

            }
            return $result;
        } catch (Exception $ex) {

        }
    }
}
?>