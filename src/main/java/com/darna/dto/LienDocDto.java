package com.darna.dto;

import java.util.List;

public class LienDocDto {

	private long idliendoc;
	private String titre_liendoc;
	private List<String> siteweb_partenaire;
	public LienDocDto(long idliendoc, String titre_liendoc, List<String> siteweb_partenaire) {
		super();
		this.idliendoc = idliendoc;
		this.titre_liendoc = titre_liendoc;
		this.siteweb_partenaire = siteweb_partenaire;
	}
	public LienDocDto() {
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
