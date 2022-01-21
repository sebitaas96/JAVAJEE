package org.ssirbu.ejerciciosJEE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejercicio4
 */
@WebServlet("/ejercicio4")
public class ejercicio4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
			pw.println("<html>"+
					"<head>"+
						"<meta charset='UTF-8'>"+
						"<title>Ejercicio 4</title>"+
					"</head>"+
					"<body>"+
						"<form method='post' action='ejercicio4'>"+
							"<label for='nombre'>Nombre</label>"+
							"<input type='text' name='nom' id='nombre'/><br/>"+
							"<input type='submit' value='Enviar'/>"+
						"</form>"+
					"</body>"+
				"</html>");
		}
		
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nom");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hola "+nombre+"</h1>");
		
	}
	
}


