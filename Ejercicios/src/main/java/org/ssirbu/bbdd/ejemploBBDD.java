package org.ssirbu.bbdd;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ejemploBBDD
 */
@WebServlet("/ejemploBBDD")
public class ejemploBBDD extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<h1>HOLA MUNDO</h1>");
		
		try {
			//Cargar driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			
			//Sentencias preparadas para evitar inyecciones sql  
			//PreparedStatement ps = con.prepareStatement("insert into persona(id,nombre)values(?,?)");
			
			//Como rellenar huecos de la sentencia preparada
			//ps.setInt(1, 4);//Primero indicamos el hueco a rellenar y luego el valor
			//ps.setString(2, "Alberto");
			
			//Eejecutar Insert , update y delete
			//ps.execute();
			//pw.println("<h2>Se ha omsertadp cprrectamente</h2>");
			
			
			
			//Hacer una select
			PreparedStatement ps2 = con.prepareStatement("select * from persona where nombre=?");
			ps2.setString(1 , "sebas");
			ResultSet rs = ps2.executeQuery();
			pw.println("<ul>");
			while(rs.next()) {
				int i1 = rs.getInt("id");
				String s1 = rs.getString("nombre");
			pw.println("<li>"+i1+" : "+s1+"</li>");
			}
			pw.println("</ul>");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
