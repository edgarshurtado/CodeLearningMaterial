/*
    Exercise description
*/



import Entidad.Participante;
import java.io.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Edgar S. Hurtado
 */


public class JavaHibernate {

    
    public static void main(String[] args) {

	    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    Participante participante = new Participante(8888, "Joan", "Gilbert Bataller", "Palma de Gandía", "PalmaRacers");

	    session.beginTransaction();
	    session.save(participante);
	    session.getTransaction().commit();


	Participante participante2 = (Participante)session.get(Participante.class, 8888);
	    System.out.println("=========================================");
	System.out.println("Nombre: " + participante2.getNombre());
	System.out.println("Apellidos: " + participante2.getApellidos());
	System.out.println("Población: " + participante2.getPoblacion());
	System.out.println("Club: " + participante2.getClub());
    	System.out.println("=========================================");

	//UPDATE
	participante2.setNombre("Edgarín");
	session.beginTransaction();
	session.update(participante2);
	session.getTransaction().commit();

	//Delete
	Participante participante3 = (Participante)session.get(Participante.class, 8888);
	session.beginTransaction();
	session.delete(participante3);
	session.getTransaction().commit();

        session.close();
    	sessionFactory.close();
    }


}
