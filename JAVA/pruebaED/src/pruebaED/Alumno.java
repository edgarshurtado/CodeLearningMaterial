package pruebaED;

public class Alumno extends Persona {
	private int nota;
	private String nia;
	
	public Alumno(int nota, String nombre, String apellidos){
		super(nombre, apellidos);
		this.nota = nota;
	}
}
