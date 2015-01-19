package pruebaED;

public class Persona {
	private String nombre;
	private String apellidos;
	private int edad;
	private int altura;
	private char genero;
	private String nif;
	private int peso;
	private String colorPelo;
	
	public Persona(String nombre, String apellidos){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = 0;
	}
	
	public Persona(String nombre, String apellidos, int edad){
		this(nombre, apellidos);
		this.edad = edad;
	}

	public void mostrar() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		if (this.edad > 0) {
			System.out.println("Edad: " + this.edad);
		}
	}
}
