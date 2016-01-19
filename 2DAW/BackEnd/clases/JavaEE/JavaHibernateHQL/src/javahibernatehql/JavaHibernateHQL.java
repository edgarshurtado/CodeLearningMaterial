/*
    Exercise description
*/

package javahibernatehql;

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


public class JavaHibernateHQL {

    
    public static void main(String[] args) {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

//	{
//	    System.out.println("Uso de List");
//	    System.out.println("-----------------------------------------");
//	    // Seleccionamos sobre la clase, no sobre las tablas
//	    Query query = session.createQuery("SELECT p FROM Participante p");
//	    List<Participante> participantes = query.list();
//	    for (Participante participante : participantes) {
//		    System.out.println("-------------------------------");
//		    System.out.println(participante.toString());
//		    System.out.println("-------------------------------");
//	    }
//	}

//	{
//	    System.out.println("Uso de List con datos escalares");
//	    System.out.println("-----------------------------------------");
//	    // Seleccionamos sobre la clase, no sobre las tablas
//	    Query query = session.createQuery("SELECT p.dorsal, p.nombre " + "FROM Participante p");
//	    List<Participante> participantes = query.list();
//	
//	    List<Object[]> listDatos = query.list();
//
//	    for (Object[] datos : listDatos) {
//			   System.out.println(datos[0] + "--" + datos[1]);	
//		}
//    	}

//	{
//	    System.out.println("Uso de List con un unico dato escalar");
//	    System.out.println("-----------------------------------------");
//	    // Seleccionamos sobre la clase, no sobre las tablas
//	    Query query = session.createQuery("SELECT p.dorsal FROM Participante p");
//	    List<Participante> participantes = query.list();
//	
//	    List<Object> listDatos = query.list();
//
//	    for (Object datos : listDatos) {
//			   System.out.println(datos);	
//		}
//    	}


//	{
//		System.out.println("Uso de unique result");
//		String hql = "SELECT p FROM Participante p WHERE p.dorsal = 22222";
//		Participante participante = (Participante)session.createQuery(hql).uniqueResult();
//		System.out.println("Participante con dorsal 22222: " + participante.getNombre());
//	}
	
	{
		System.out.println("Mostrar una pagina");
		int tamanyoPagina = 10;
		int paginaMostrar = 7;
		String hql = "SELECT p FROM Participante p ORDER BY p.dorsal";
		Query query = session.createQuery(hql);
		query.setMaxResults(tamanyoPagina);
		query.setFirstResult(paginaMostrar * tamanyoPagina);
		List<Participante> listaParticipantes = query.list();

		   for (Participante participante : listaParticipantes) {
		    	System.out.println("-------------------------------");
		   	System.out.println(participante.toString());
		    	System.out.println("-------------------------------");
	    }
	
		
	}

	{
		System.out.println("Calcular el numero de paginas");
		int tamanyoPagina = 10;
		long numTotalObjetos = (Long)session.createQuery("SELECT count(*) from Participante p").uniqueResult();

		int numPaginas = (int)Math.round((double)numTotalObjetos/(double)tamanyoPagina);
		System.out.println("Nombre de paginas: " + numPaginas);

	}
	
	session.close();
	sessionFactory.close();
    }
}
