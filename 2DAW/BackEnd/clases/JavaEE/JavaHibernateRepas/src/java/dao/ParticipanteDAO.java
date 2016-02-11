/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Participante;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class ParticipanteDAO {
	public static void guardar(Participante participante){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trns = null;
		try {
			trns = session.beginTransaction();
			session.saveOrUpdate(participante);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static ArrayList<Participante> getAllParticipantes(){
		Session session = HibernateUtil.getSessionFactory().openSession();

		String hql = "SELECT p FROM Participante p ORDER BY apellidos";
		Query query = session.createQuery(hql);

		ArrayList<Participante> listaParticipantes = (ArrayList<Participante>)query.list();

		session.close();
		return listaParticipantes; 
	}

	public static Participante getParticipanteByDorsal(int dorsal){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Participante participante = null;
		String hql = "SELECT p FROM Participante p WHERE dorsal=:dorsal";
		Query query = session.createQuery(hql).setParameter("dorsal", dorsal);

		participante = (Participante) query.uniqueResult();
		return participante; 
	}
}
