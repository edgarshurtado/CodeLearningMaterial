package pruebaED;

public class Alumno extends Persona {
	private int nota;
	private String nia;
	
	public Alumno(String nombre, String apellidos, int nota){
		super(nombre, apellidos);
		this.nota = nota;
	}
}
