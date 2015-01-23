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
		this.altura = 0;
		this.peso = 0;
		this.genero = 'u';
		this.nif = "";
		this.colorPelo = "unknown";
	}
	
	public Persona(String nombre, String apellidos, int edad){
		this(nombre, apellidos);
		this.edad = edad;
	}
	
	public Persona(String nombre, String apellidos, char genero){
		this(nombre, apellidos);
		this.genero = genero;
	}

	public void mostrar() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		if (this.edad > 0) {
			System.out.println("Edad: " + this.edad);
		}
	}
}
