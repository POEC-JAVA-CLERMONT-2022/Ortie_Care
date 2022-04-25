package com.ipme.ortiecare.services.DTO;

public class SolDTO {
	
	private String nomSol;
	private String textureSol;
	private String structureSol;
	private String avantageSol;
	private String inconvenientSol;
	
	public SolDTO() {
		
	}

	public SolDTO(String nomSol, String textureSol, String structureSol, String avantageSol, String inconvenientSol) {
		
		this.nomSol = nomSol;
		this.textureSol = textureSol;
		this.structureSol = structureSol;
		this.avantageSol = avantageSol;
		this.inconvenientSol = inconvenientSol;
	}

	public String getNomSol() {return nomSol;}

	public String getTextureSol() {return textureSol;}

	public String getStructureSol() {return structureSol;}

	public String getAvantageSol() {return avantageSol;}

	public String getInconvenientSol() {return inconvenientSol;}
	
	
}
