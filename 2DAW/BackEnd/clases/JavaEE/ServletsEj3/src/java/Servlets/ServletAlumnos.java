/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidad.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rumil
 */
@WebServlet(name = "ServletAlumnos", urlPatterns = {"/ServletAlumnos"})
public class ServletAlumnos extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */

	private ArrayList<Alumno> alumnos = new ArrayList<>();
	
	@Override
	public void init()
		throws ServletException {
		this.alumnos.add(new Alumno("123", "Edgar", "Sánchez Hurtado", "2º Daw"));
		this.alumnos.add(new Alumno("234", "Mari", "Hurtado Segura", "1º Daw"));
		this.alumnos.add(new Alumno("345", "Gines", "Sánchez Gómez", "2º Dam"));
		
		super.init(); //To change body of generated methods, choose Tools | Templates.

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dniRequest = (String)request.getParameter("dni");
		Alumno _alumno = this.recuperarAlumno(dniRequest);

		request.setAttribute("alumno", _alumno);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/MuestraDatosAlumno.jsp");
		rd.forward(request, response);
		
	}

	private Alumno recuperarAlumno(String dni){
		Alumno _alumno = new Alumno("666","Devil", "Satan", "Hell");

		for (Alumno alumno : this.alumnos) {
			if(dni.equals(alumno.getDni())){
				_alumno = alumno;
			}
		}
		return _alumno;

	}
	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
