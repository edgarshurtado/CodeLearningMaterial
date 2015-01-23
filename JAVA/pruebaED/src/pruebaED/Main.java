package pruebaED;

public class Main {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Edgar", "SH");
		Persona persona2 = new Persona("Edgar", "SH", 25);
		String[] asignaturas = {"ED", "Programación"};
		Persona persona3 = new Profesor("Germán", "Gascón", "Jaume el just",
				"informática", asignaturas);
		persona3.mostrar();
	}

}
