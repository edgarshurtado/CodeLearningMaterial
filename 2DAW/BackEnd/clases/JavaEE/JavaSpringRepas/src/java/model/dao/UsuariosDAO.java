/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.entidad.Usuarios;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rumil
 */
public class UsuariosDAO {
	/*
	Obtiene todos los usuarios de la base de datos y los devuelve en un arraylist
	*/
	public static ArrayList<Usuarios> getAllUsers(){
		
		ArrayList<Usuarios> lista = null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "SELECT u FROM Usuarios u";

			Query query = session.createQuery(hql);

			lista = (ArrayList<Usuarios>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
