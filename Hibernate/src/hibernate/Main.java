package hibernate;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Aficion;
import hibernate.entities.Pais;
import hibernate.entities.Persona;

public class Main {
	
	
	
	private static Session obtenerSesion() {
		//Como hacer para que un objeto persista
		/*1-Crear una fabrica de sesiones y le pedimos que cree una 
		 * sesion ,los imports todos de hibernate*/
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}
	
	
	private static void crearPersona(String nombre, String nif , Pais pa) {
		Persona p = new Persona(nombre, nif , pa);
		guardarPersona(p);
	}
	
	private static void guardarPersona(Persona p) {
		Session session = obtenerSesion();
		
		/*2-Guardar un POJO*/
		Transaction t = session.beginTransaction();
		   session.save(p);
		   t.commit();
	}
	private static void guardarPais(Pais p) {
		Session session = obtenerSesion();
		Transaction t = session.beginTransaction();
		   session.save(p);
		   t.commit();
	}
	private static void guardarAficion(Aficion afi) {
		Session session = obtenerSesion();
		Transaction t = session.beginTransaction();
		   session.save(afi);
		   t.commit();
	}
	private static void actualizarPersona(Persona p) {
		Session session = obtenerSesion();
		
		/*3-Actualizar un POJO*/
		Transaction t = session.beginTransaction();
		   session.merge(p);
		   t.commit();
	}
	private static void borrarPersona(Persona p) {
		Session session = obtenerSesion();
		
		/*4-Borrar un POJO*/
		Transaction t = session.beginTransaction();
		   session.delete(p);
		   t.commit();
	}
	
	private static Persona recuperarPersonaID(Long id) {
		Session session = obtenerSesion();
		Persona p = session.get(Persona.class, id);
		return p;
	}
	private static Pais recuperarPaisID(Long id) {
		Session session = obtenerSesion();
		Pais p = session.get(Pais.class, id);
		return p;
	}
	private static Aficion recuperarAficionID(Long id) {
		Session session = obtenerSesion();
		Aficion a = session.get(Aficion.class, id);
		return a;
	}
	
	private static List<Persona> recuperarPersonaNombre(String nombre){
		Session session = obtenerSesion();
		return session.createQuery("from Persona where nombre = :x").setParameter("x", nombre).list();

	}
	private static List<Persona> recuperarPaisNombre(String nombre){
		Session session = obtenerSesion();
		return session.createQuery("from Pais where nombre = :x").setParameter("x", nombre).list();

	}
	
	private static List<Persona> recuperarTodasPersonas(){
		Session session = obtenerSesion();
		return session.createQuery("from Persona").list();
	}
	
	
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
			/*8-Cada vez que traemos un atributo unico como dni a la clase ha que 
			 * ponerle un @Column(unique=true) para decirle que es un atributo unico */
		
		
		//Creamos persona
		/*Pais pais = new Pais("España");
		guardarPais(pais);
		crearPersona("Sara" , "00000000L" ,pais);*/
		
		//Recuperamos una lista de personas de un pais
		Pais pais = recuperarPaisID(1L);
		for(Persona p:pais.getPersonasNacidas()) {
			System.out.println(p);
		}
		
		//Creamos aficion
		Aficion afi = new Aficion("Baloncesto");
		guardarAficion(afi);
		
		//Asociamos aficiones a una persona
		Aficion a1 = recuperarAficionID(1L);
		Persona p = recuperarPersonaID(1L);
		p.setAficionesGusta(List.of(a1));
		actualizarPersona(p);
	}

	
}
