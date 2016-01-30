/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CgStoreDAO;
import model.entidad.CgStore;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Rumil
 */
public class CgStoreController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
		ModelAndView mv = new ModelAndView("tiendas");

		try {
			//Recogemos los datos del modelo y los enviamos a la vista.
			mv.addObject("titulo", "Listado de tiendas");
			List<CgStore> listadoTiendas = CgStoreDAO.listarTiendas();

			mv.addObject("lista", listadoTiendas);
			mv.addObject("mensaje", "Mensaje desde el controlador");
			// carpeta base relativa
			mv.addObject("cp", hsr.getContextPath());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
	public String borrar(@PathVariable("id") Long id, ModelMap map,
		HttpServletRequest request){
			

		map.addAttribute("cp", request.getContextPath());

		return "/borrar";
	}
}
