/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.util.List;
import model.entidad.CgStore;
import model.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Rumil
 */
public class CgStoreDAO {
	public static List<CgStore> listarTiendas(){
		List<CgStore> lista = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {

			String hql = "SELECT t FROM CgStore t";

			lista = session.createQuery(hql).list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	public static int eliminar(CgStore tienda){
		int registrosEliminados = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(tienda);
			session.getTransaction().commit();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}finally {
			session.close();
		}

	}


	public static void altaModifica(CgStore tienda){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(tienda);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}

	}
}
