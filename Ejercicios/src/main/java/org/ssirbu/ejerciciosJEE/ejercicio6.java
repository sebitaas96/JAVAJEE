package org.ssirbu.ejerciciosJEE;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejercicio6
 */
@WebServlet("/ejercicio6")
public class ejercicio6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String , String> usuarios = new HashMap<String , String>();
		usuarios.put("Sebas","sebas");
		usuarios.put("Sara","sara");
		
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
	
			pw.println("<html>"+
					"<head>"+
						"<meta charset='UTF-8'>"+
						"<title>Ejercicio 6</title>"+
					"</head>"+
					"<body>"+
						"<form method='post' action='ejercicio10'>"+
							"<label for='nombre'>Nombre</label>"+
							"<input type='text' name='nom' id='nombre'/><br/>"+
							"<label for='aficiones'>Aficiones</label><br/>"+
							"<label for='bailar'>Bailar: </label>"+
							"<input type='checkbox' name='afi[]' value='bailar' id='bailar'/><br/>"+
							"<label for='cantar'>Cantar: </label>"+
							"<input type='checkbox' name='afi[]' value='cantar' id='cantar'/><br/>"+
							"<input type='submit' value='Enviar'/>"+
						"</form>"+
					"</body>"+
				"</html>");
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] aficiones = request.getParameterValues("afi[]");
		String nombre = request.getParameter("nom");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(nombre == null || nombre.equals("")) {

			pw.println("<h1>Debes insertar un nombre</h1>");
		}
		else if((nombre != null && aficiones==null) ||(nombre != "" && aficiones==null)) {
			pw.println("<h1>A "+nombre+" no le gusta nada</h1>");
		}
		else {
			String aficionesgusta = "";
			for(String aficion:aficiones){
				aficionesgusta += ", "+aficion;
			}
			pw.println("<h1>A "+nombre+"le gusta "+aficionesgusta+"</h1>");
		}
		
		
	}

}
