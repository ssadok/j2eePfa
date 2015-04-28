package domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mots
 *
 */
@Entity

public class Mots implements Serializable {

	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 5813232376274570663L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Libelle;
	public Mots(Integer id, String libelle) {
		super();
		this.id = id;
		this.Libelle = libelle;
	}
	public Mots() {
		super();
	}   
	public Integer getid() {
		return this.id;
	}

	public void setid(Integer id) {
		this.id = id;
	}   
	public String getLibelle() {
		return this.Libelle;
	}

	public void setLibelle(String Libelle) {
		this.Libelle = Libelle;
	}
   
}
