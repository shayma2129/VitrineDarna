package com.darna.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIENDOC")
public class LienDoc {
	
	/**
	 *  Id liendoc
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDliendoc")
	private long idliendoc;
	/**
	 * titre liendoc
     */
    @Column(name="titre_liendoc",length=180)
	private String titre_liendoc;
    
    /**
     * siteweb_partenaire
     */
    @ElementCollection(targetClass=String.class)
    @Column(name="siteweb_partenaire")
   	private List<String> siteweb_partenaire;
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lienDoc")
   	private Set<Document> documents = new HashSet<>();

	

	public LienDoc(long idliendoc, String titre_liendoc, List<String> siteweb_partenaire, Set<Document> documents) {
		super();
		this.idliendoc = idliendoc;
		this.titre_liendoc = titre_liendoc;
		this.siteweb_partenaire = siteweb_partenaire;
		this.documents = documents;
	}

	public LienDoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdliendoc() {
		return idliendoc;
	}

	public void setIdliendoc(long idliendoc) {
		this.idliendoc = idliendoc;
	}

	public String getTitre_liendoc() {
		return titre_liendoc;
	}

	public void setTitre_liendoc(String titre_liendoc) {
		this.titre_liendoc = titre_liendoc;
	}

	public List<String> getSiteweb_partenaire() {
		return siteweb_partenaire;
	}

	public void setSiteweb_partenaire(List<String> siteweb_partenaire) {
		this.siteweb_partenaire = siteweb_partenaire;
	}

    
}
