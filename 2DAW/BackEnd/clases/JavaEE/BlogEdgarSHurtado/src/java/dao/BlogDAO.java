/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Post;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class BlogDAO {

	private static final SessionFactory sf = HibernateUtil.getSessionFactory();

	public static ArrayList<Post> getAllPosts() {
		ArrayList<Post> listaPosts = new ArrayList<>();

		Session session = sf.openSession();

		String hql = "SELECT p from Post p ORDER BY post_date DESC";

		listaPosts = (ArrayList < Post >)session.createQuery(hql).list();

		return listaPosts;
	}
	
	public static Post getPostById(String slug){
		Post postSeleccionado = null;

		Session session = sf.openSession();

		String hql = "SELECT p FROM Post p WHERE post_slug=:slug";

		postSeleccionado = (Post)session.createQuery(hql)
			.setParameter("slug", slug).uniqueResult();

		return postSeleccionado;
	}

	public static void deletePost(Post p) throws Exception{
		Session session = sf.openSession();

		session.beginTransaction();
		session.delete(p);
		session.getTransaction().commit();
	}

	public static void newPost(Post p){
		Session session = sf.openSession();

		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
	}
	
	
}
