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
		if (this.nif.length() > 0){
			System.out.println("NIF: " + this.nif);
		}
	}
	
	public void setNif(String nif){
		try {
			int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
			char letra = nif.charAt(nif.length() - 1);
			int resto = numero % 23;

			// tabla equivalencias
			char[] equivalencias;
			equivalencias = new char[] { 'T', 'R', 'W', 'A', 'G', 'M', 'Y',
					'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
					'L', 'C', 'K', 'E' };

			// Comprobación de si coincide
			if (equivalencias[resto] == letra) {
				this.nif = nif;
			} else {
				System.out.println("El número no coincide con la letra");
			}
		} catch (NumberFormatException e) {
			System.out.println("Formato incorrecto");
		} catch (Exception e){
			System.out.println("Error desconocideo. Compruebe que el formato sea: 200000000A");
		}
	}
	
	public String getNif(){
		return this.nif;
	}
}
