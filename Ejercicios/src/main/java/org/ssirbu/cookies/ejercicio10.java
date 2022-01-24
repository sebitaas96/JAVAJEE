package org.ssirbu.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejercicio10
 */
@WebServlet("/ejercicio10")
public class ejercicio10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html>"+
				"<head>"+
					"<meta charset='UTF-8'>"+
					"<title>Ejercicio 10</title>"+
				"</head>"+
				"<body>"+
					"<form method='post' action='ejercicio10'>"
					+ "<label for='user'>Usuario</label>"
					+ "<input type='text' name='user' id='user'><br/>"
					+ "<label for='pwd'>Password</label>"
					+ "<input type='password' name='pwd' id='pwd'><br/>"
					+ "<input type='submit' value='Enviar'/></form>");
				pw.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String , String> usuarios = new HashMap<String , String>();
		usuarios.put("Sebas","sebas");
		usuarios.put("Sara","sara");
		
		String nombre = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String tiempoTranscurrido = "";
		
		Cookie[]tiempoT = request.getCookies();
		if(tiempoT !=null) {
		   tiempoTranscurrido = obtenerCooki(nombre,tiempoT);	
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(usuarios.get(nombre)!=null && usuarios.get(nombre).equals(pwd)) {

			int timing = (int) System.currentTimeMillis();
			String milisegundos =""+(timing);
			Cookie tiempo = new Cookie(nombre,milisegundos);
			response.addCookie(tiempo);
			
			pw.println("<h1>Bienvenido "+nombre+"</h1>"
					+ "<form method='get' action='ejercicio10'>"
					+ "<input type='submit' value='logout'>");
			if(tiempoTranscurrido !="") {
			    long horaDesconexion = Long.parseLong(tiempoTranscurrido);
			    long horaActual = System.currentTimeMillis();
			    long diferencia = (horaActual-horaDesconexion)/1000;
			    if(diferencia>=60) {
			    	pw.println("Hace mas de un minuto que no te vemos por aqui");	
			    }
			    else {
			    	pw.println("Hace mas de "+tiempoTranscurrido+" que no te vemos por aqui");		
			    }
				
			}
			else {
				pw.println(	"Es la primera vez que te vemos por aqui");
			}
		    pw.println(	"</form>");
		}
		else {
			pw.println("<h1>Credenciales incorrectas</h1>");
		}
		
	}
	
	public String obtenerCooki(String nombreCookie,Cookie[] cookies) {
		 String cookie = "";
		 for(Cookie cooki:cookies) {
			 cookie = cooki.getName().equals(nombreCookie)?cooki.getValue():"";
		 }
		return cookie;
	}

}
