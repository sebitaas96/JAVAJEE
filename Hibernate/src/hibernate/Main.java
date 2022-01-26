package hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Persona;

public class Main {
	public static void main(String[] args) {

		
		//Pasos a seguir para convertir un objeto en persistente
			//1-Asegurarse que tiene un constructor sin parametros
			//2-Asegurarse de que todos sus atributos sean privados
			//3-Tener todos los geters y seters publicos
			//4-Añadir un atributo id de tipo LONG con sus getter y seter sin meterlo en el constructor
			//5-Anotar la clase del objeto con el @Entity de javax.persistence
			/*6-Anotar el atributo id con @id y 
			 * con @GeneratedValue(strategy = GenerationType.IDENTITY) para que lo genere
			 * el como quiera el ids
			 * */
			/*7-Añadir una entrada maping class en el hibernate.cfg.xml*/
		
	}
	
	private static void crearPersona(String nombre) {
		Persona p = new Persona(nombre);
		guardarPersona(p);
	}
	
	private static void guardarPersona(Persona p) {
		//Como hacer para que un objeto persista
		/*1-Crear una fabrica de sesiones y le pedimos que cree una 
		 * sesion ,los imports todos de hibernate*/
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		
		/*2-Guardar un POJO*/
		Transaction t = session.beginTransaction();
		   session.save(p);
		   t.commit();
	}
}
