package com.ipme.ortiecare.services.DTO;

import java.util.UUID;

import com.ipme.ortiecare.model.Sol;

public class SolDTO {
	
	private UUID idSol;
	private String nomSol;
	private String textureSol;
	private String structureSol;
	private String avantageSol;
	private String inconvenientSol;
	
	public SolDTO() {
		
	}

	public SolDTO(UUID idSol, String nomSol, String textureSol, String structureSol, String avantageSol, String inconvenientSol) {
		
		this.idSol = idSol;
		this.nomSol = nomSol;
		this.textureSol = textureSol;
		this.structureSol = structureSol;
		this.avantageSol = avantageSol;
		this.inconvenientSol = inconvenientSol;
	}

	public UUID getIdSol() {return idSol;}
	
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
