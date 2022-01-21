package org.ssirbu.redireciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tres
 */
@WebServlet("/Tres")
public class Tres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<h1>TRES</h1>");
		
		/*Otra opcion que tenemos es el dispatcher , me manda una url y le puedes pasar este mismo
		Este es mismo servlet , es decir su peticion y respuesta para que el dos trabaje en su nombre
		
		Esto sirve para hacer controaldores de fachada , es decir que otro haga el trabajo en mi nombre , sirve para 
		ocultar archivos
		*/
		//Si queremos pasarle un dato
		request.setAttribute("nombre", "Alberto");
		request.getRequestDispatcher("Ejercicios/Dos").forward(request, response);
		
		/*Otra forma de hacer dispatcher*/
		request.getRequestDispatcher("Ejercicios/Dos").include(request, response);
		
	}




}
