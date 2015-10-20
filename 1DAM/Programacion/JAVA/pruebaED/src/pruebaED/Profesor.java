package pruebaED;

public class Profesor extends Persona {
	private String colegio;
	private String departamento;
	private String[] asignaturas;
	
	public Profesor(String nombre, String apellido, String colegio, 
			String departamento, String[] asignaturas){
		super(nombre, apellido);
		this.colegio = colegio;
		this.departamento = departamento;
		this.asignaturas = new String[asignaturas.length];
		for(int i = 0; i < asignaturas.length; i++){
			this.asignaturas[i] = asignaturas[i];
		}
	}
	
	public void mostrar(){
		super.mostrar();
		System.out.println("Departamento: " + this.departamento);
		System.out.print("Asignaturas que da: ");
		for(String asignatura: this.asignaturas){
			System.out.print(asignatura + ", ");
		}
	}
	
}
