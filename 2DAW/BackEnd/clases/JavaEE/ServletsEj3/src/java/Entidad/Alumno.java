/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Rumil
 */
public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private String curso;

	public Alumno() {
	}

	
	public Alumno(String dni, String nombre, String apellidos, String curso) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
