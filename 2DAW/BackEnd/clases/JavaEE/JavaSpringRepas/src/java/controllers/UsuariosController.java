/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsuariosDAO;
import model.entidad.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Rumil
 */
public class UsuariosController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView mv = new ModelAndView("usuarios");

		ArrayList<Usuarios> lista = UsuariosDAO.getAllUsers();

		mv.addObject("listaUsuarios", lista); // Adjuntar JavaBean
		
		return mv;
	}
	
}
