package org.ssirbu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Nosotros configuramos  el comportamiento estander que se encuentra entro del DOget
		
		/*1- Request:Este encapsula la casuistica de la peticion*/
		
		
		/*2-Como consultamos parametros de entrada , ses decir parametros que se envian a traves de la URI*/
			
			//Solicitamos el parametro con nombre de variable nombre que se envia a traves de la URI y mediante get porque estamos en DOGET
			String nombre = request.getParameter("nombre");
			
		
		/*3-Cuando nos llegan parametros multiples como por ejemplo un checkbox*/
			
			//Comprobamos como si fuese un isset de que llegan esos parametros
			
			String[] idiomas = request.getParameterValues("ckIdioma[]");
			if(idiomas==null) {
				System.out.println("Idioma invalido");
			
		/*4-Response: Este encapsula la csauistica de la respuesta, lo usamos cuando queremos sacar algo por la conexion
		 * HTTP*/
			//Le inidcaremos que recibira un texto para interpretarlo como html
			response.setContentType("text/html");
			//Le pedimos un canal de salida
			
			/*PrintWriter salida = response.getWriter();
			salida.println("<h1>Hola Mundo</h1>");*/
			
			//Las dos instruciones anteriores las podemos hacer en un paso
			response.getWriter().println("<h1>Hola "+nombre+"</h1>");
	}
	
	

}
