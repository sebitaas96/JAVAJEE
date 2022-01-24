package org.ssirbu.sesiones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ejercicio1
 */
@WebServlet("/ejercicio11")
public class ejercicio11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html>"+
				"<head>"+
					"<meta charset='UTF-8'>"+
					"<title>Ejercicio 11</title>"+
				"</head>"+
				"<body>"+
					"<form method='post' action='ejercicio11'>"
					+ "<label for='user'>Usuario</label>"
					+ "<input type='text' name='user' id='user'><br/>"
					+ "<label for='pwd'>Password</label>"
					+ "<input type='password' name='pwd' id='pwd'><br/>"
					+ "<input type='submit' value='Enviar'/></form>");
				pw.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);

		
		Map<String , String> usuarios = new HashMap<String , String>();
		usuarios.put("Sebas","sebas");
		usuarios.put("Sara","sara");
		
		String nombre = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		int visitas =0;
		
		
		if((Integer) sesion.getAttribute(nombre) !=null) {
			visitas = (Integer)sesion.getAttribute(nombre);
			visitas++;
			sesion.setAttribute(nombre, visitas);
		}
		else {
			sesion.setAttribute(nombre, visitas);
		}
		
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(usuarios.get(nombre)!=null && usuarios.get(nombre).equals(pwd)) {
	
			pw.println("<h1>Bienvenido "+nombre+"</h1>"
					+ "<form method='get' action='ejercicio11'>"
					+ "<input type='submit' value='logout'>");

			    if(visitas>0) {
			    	pw.println("Los has visitado "+visitas+" veces");	
			    }
			    else {
			    	pw.println("No has visitado ninguna vez la pagina");		
			    }

		    pw.println(	"</form>");
		}
		else {
			pw.println("<h1>Credenciales incorrectas</h1>");
		}

}
	}
