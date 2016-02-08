/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Entidad.Seguro;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class Ejer1 {
	public static void main(String[] args) {
		// Insertar un seguro
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Seguro seguro1 = new Seguro(3, "200P", "Edgar", "S.", "Hurtado", 26, 0, new Date());

		session.save(seguro1);

		session.getTransaction().commit();
		session.close();
		
	}
}
