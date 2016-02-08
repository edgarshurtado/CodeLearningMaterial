/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Rumil
 */
public class Seguro implements Serializable{
	int IdSeguro;
	String nif;
	String nombre;
	String ape1;
	String ape2;
	int edad;
	int numHijos;
	Date fechaCreacion;

	public Seguro() {
	}

	public Seguro(int IdSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, Date fechaCreacion) {
		this.IdSeguro = IdSeguro;
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.numHijos = numHijos;
		this.fechaCreacion = fechaCreacion;
	}

	

	public int getIdSeguro() {
		return IdSeguro;
	}

	public void setIdSeguro(int IdSeguro) {
		this.IdSeguro = IdSeguro;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
}
