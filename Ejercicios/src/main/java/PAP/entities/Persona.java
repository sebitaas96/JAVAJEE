package PAP.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@ManyToOne
	private Pais paisNace;
	
	@ManyToMany
	private Collection<Aficion>aficionesGusta;
	
	@Column(unique=true)
	private String nif;
	
	public Persona() {
		this.nombre = "SEBAS";
		this.nif = "0000000T";
		this.aficionesGusta = new ArrayList<Aficion>();
	}
	
	public Persona(String nombre , String nif , Pais paisNace) {
		this.nombre = nombre;
		this.nif = nif;
		this.paisNace = paisNace;
		paisNace.getPersonasNacidas().add(this);
		this.aficionesGusta = new ArrayList<Aficion>();
	}
	
	//==========================================
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	

	public Pais getPaisNace() {
		return paisNace;
	}

	public void setPaisNace(Pais paisNace) {
		this.paisNace = paisNace;
	}
	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}

	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		for(Aficion aficion: aficionesGusta) {
			this.aficionesGusta.add(aficion);
		}
		//this.aficionesGusta = aficionesGusta;
	}

	
	//==========================================


	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}
	
	

	
}
