package com.ipme.ortiecare.services.DTO;

public class ConseilDeCultureDTO {
	
	private String titre;
	private String description;
	
	public ConseilDeCultureDTO() {}
	public ConseilDeCultureDTO(String titre, String description)
	{
		this.titre = titre;
		this.description = description;	
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
