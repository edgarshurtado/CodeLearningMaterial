
package model.dao;

import java.util.List;
import model.entidad.Participantes;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author AIDA
 */
public class ParticipanteDAO {
    
    public static List<Participantes> llistaParticipants(){
        
        List<Participantes> llista = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();//nem a obrir una sesion
            String hql = "FROM Participantes"; //Altra forma de fer-ho
            Query q = session.createQuery(hql);
            return q.list(); //per a traureu
            
        }catch(ExceptionInInitializerError ex){
            ex.printStackTrace();
            return null;
            
        }finally{
            HibernateUtil.getSessionFactory().close();
        }
        
        
        
    }
    
}
