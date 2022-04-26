package com.ipme.ortiecare.services.DTO;

import com.ipme.ortiecare.model.Sol;

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

	
	
	//Pour le test fonctionnel de relation Sol/Legume - N'est sans doute pas bon.
	public static Object save(Class<Sol> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
