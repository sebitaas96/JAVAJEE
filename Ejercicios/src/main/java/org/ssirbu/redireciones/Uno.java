package org.ssirbu.redireciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Uno
 */
@WebServlet("/Uno")
public class Uno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
		response.getWriter().println("<h1>UNO</h1>");
		
		//Una opcion para hacer uan redireccion  es usar el sendRedirect 
	
		response.sendRedirect("/Ejercicios/Dos");
		
	
		
	}

}
