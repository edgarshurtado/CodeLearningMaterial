/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Rumil
 */ 

@Entity
@Table(name="Profesor")
public class Profesor implements Serializable{
	
	@Id
	private int id_usuario;

	@NotNull // Obligamos así que no sea nulo
	@Size(min=3, max=50)
	private String nombre;

	@NotNull // Obligamos así que no sea nulo
	@Size(min=3, max=50)
	private String ape1;

	@NotNull // Obligamos así que no sea nulo
	@Size(min=3, max=50)
	private String ape2;

	public Profesor() {
	}

	public Profesor(String nombre, String ape1, String ape2) {
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	
}
