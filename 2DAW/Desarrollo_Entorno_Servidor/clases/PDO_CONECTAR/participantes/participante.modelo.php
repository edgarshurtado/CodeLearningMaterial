<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class ParticipanteModel {
    private $pdo;

    function __construct() {
        $dsn = "mysql:host=localhost;dbname=Carreras";
        $username = "root";
        $passwd = "";
        try {
            $this->pdo = new PDO($dsn, $username, $passwd);
            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (Exception $ex) {
            die($ex->getMessage());
        }
    }

    public function eliminar($id){
        try {
            $sql = "DELETE FROM participantes WHERE IdParticipante = ?";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(array($id));
        } catch (Exception $ex) {
            die($ex->getMessage());
        }
    }

    public function obtener($id) {
        try {
            $sql = "SELECT * FROM participantes WHERE IdParticipante=?";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(array($id));
            $fila = $stmt->fetch(PDO::FETCH_OBJ);
            $participante1 = new Participante1();
            $participante1->__SET("IdParticipante", $fila->IdParticipante);
            $participante1->__SET("Nombre", $fila->Nombre);
            $participante1->__SET("Apellidos", $fila->Apellidos);
            $participante1->__SET("Poblacion", $fila->Poblacion);
            $participante1->__SET("CLUB", $fila->CLUB);
            return $participante1;
        } catch (Exception $ex) {
            die($ex->getMessage());
        }
    }
    public function actualizar(Participante1 $data) {
        try {
            $sql = "UPDATE participantes SET  Nombre = ?,"
                    . " Apellidos = ?, Poblacion = ?, CLUB = ?"
                    . " WHERE IdParticipante=?";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(
                    array(
                        $data->__GET("Nombre"),
                        $data->__GET("Apellidos"),
                        $data->__GET("Poblacion"),
                        $data->__GET("CLUB"),
                        $data->__GET("IdParticipante")
                    ));

        } catch (Exception $ex) {
            die($ex->getMessage());
        }
    }
    public function insertar(Participante1 $data) {
        try {
            $sql = "INSERT INTO participantes (Nombre, Apellidos, Poblacion, CLUB) VALUES (?,?,?,?)";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(
                    array(
                        $data->__GET("Nombre"),
                        $data->__GET("Apellidos"),
                        $data->__GET("Poblacion"),
                        $data->__GET("CLUB")
                    ));

        } catch (Exception $ex) {
            die($ex->getMessage());
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