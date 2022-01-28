package PAP.model;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import PAP.entities.Pais;

public class PaisModel {
	
	private Session sesion;
	
	
	public PaisModel() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		this.sesion= sf.openSession();
	
	}	

	public void savePais(String nombre) {
		Transaction t = this.sesion.beginTransaction();
		   this.sesion.save(new Pais(nombre));
		   t.commit();
	}

	public List<Pais> getPaises() {
		
		return null;
	}
}
