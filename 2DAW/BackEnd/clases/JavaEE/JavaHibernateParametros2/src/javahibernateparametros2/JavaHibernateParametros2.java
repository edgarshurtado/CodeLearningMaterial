/*
    Exercise description
*/

package javahibernateparametros2;

import Entidad.Participante;
import java.io.*;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Edgar S. Hurtado
 */


public class JavaHibernateParametros2 {

    
    public static void main(String[] args) {
      	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	{
		System.out.println("Parametro posicional");
		Query query = session.createQuery("SELECT p FROM Participante p "
			+ "WHERE p.club = ? AND p.poblacion = ?");
		query.setString(0, "ATLETAS NUCLEO DURO DENIA");
		query.setString(1, "DENIA");

		List<Participante> participantes = query.list();

		for (Participante participante : participantes) {
			System.out.println("================================");
			System.out.println(participante.toString());
			System.out.println("================================");
		}
	}
	{
		System.out.println("Parametro con nombre");
		String club = "ATLETAS NUCLEO DURO DENIA";
		String poblacion = "DENIA";

		Query query = session.createQuery("SELECT p FROM Participante p "
			+ "WHERE p.club = :Club AND p.poblacion = :Poblacion");

		query.setString("Club",club);
		query.setString("Poblacion", poblacion);

		List<Participante> participantes = query.list();

		for (Participante participante : participantes) {
			System.out.println("================================");
			System.out.println(participante.toString());
			System.out.println("================================");
		}
	}
	{
		System.out.println("Metodos encadenados");
		String club = "ATLETAS NUCLEO DURO DENIA";
		String poblacion = "DENIA";

		Query query = session.createQuery("SELECT p FROM Participante p "
			+ "WHERE p.club = :Club AND p.poblacion = :Poblacion")
			.setParameter("Club",club)
			.setParameter("Poblacion", poblacion);

		List<Participante> participantes = query.list();

		for (Participante participante : participantes) {
			System.out.println("================================");
			System.out.println(participante.toString());
			System.out.println("================================");
		}
	}
	session.close();
	sessionFactory.close();
    }

}
