/*
    Exercise description
*/

package validaciones;

import Entidad.Profesor;
import Entidad.Usuario;
import java.io.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Edgar S. Hurtado
 */


public class Validaciones {

    
    public static void main(String[] args) {
       Usuario profe = new Usuario("algo", "CA", null, "Gómez", "12345678", "5678901");

       SessionFactory sessionFactory;
       Session session = null;
    	sessionFactory = HibernateUtil.getSessionFactory();
    	session  = sessionFactory.openSession();
       try {

	    session.beginTransaction();
	    session.save(profe);
	    session.getTransaction().commit();


	    } catch (ConstraintViolationException ex) {
		    session.getTransaction().rollback();
		    System.out.println("No se ha podido realizar la inserción");
		    for(ConstraintViolation cViolation : ex.getConstraintViolations()){
			    System.out.println("En el campo "
				    + cViolation.getPropertyPath()
			    	+ ":" + cViolation.getMessage());
		    }
	    }finally{
	    session.close();
	    sessionFactory.close();
       }
       
    }

}
