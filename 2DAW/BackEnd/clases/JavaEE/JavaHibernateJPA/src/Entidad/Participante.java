/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rumil
 */

@Entity
@Table(name="participantes")
public class Participante implements Serializable{

	@Id
	@Column(name="Dorsal")
	private int dorsal;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Apellidos")
	private String apellidos;

	@Column(name="Poblacion")
	private String poblacion;

	@Column(name="CLUB")
	private String club;

	public Participante() {
	}

	public Participante(int dorsal, String nombre, String apellidos, String poblacion, String club) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.poblacion = poblacion;
		this.club = club;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	
}
