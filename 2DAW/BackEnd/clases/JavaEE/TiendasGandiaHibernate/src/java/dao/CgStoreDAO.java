/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CgStore;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class CgStoreDAO {
	private static final SessionFactory sf = HibernateUtil.getSessionFactory();
	public static ArrayList<CgStore> listarTiendas(){
		Session session = sf.openSession();

		ArrayList<CgStore> listaTiendas = new ArrayList<>();
		String hql = "SELECT t FROM CgStore t";

		try {
			listaTiendas = (ArrayList<CgStore>)session.createQuery(hql).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			session.close();
		}

		return listaTiendas;
	}

	public static void createTienda(CgStore tienda) throws Exception{

		Session session = sf.openSession();

		session.beginTransaction();
		session.save(tienda);
		session.getTransaction().commit();
			
	}
	
}
