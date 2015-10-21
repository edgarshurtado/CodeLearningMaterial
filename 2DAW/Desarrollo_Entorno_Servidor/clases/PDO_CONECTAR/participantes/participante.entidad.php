<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Participante1{
    private $IdParticipante;
    private $Nombre;
    private $Apellidos;
    private $Poblacion;
    private $CLUB;
    
    public function __GET($k) {
        return $this->$k;
    }
    public function __SET($k, $v) {
        $this->$k = $v;
    }
}