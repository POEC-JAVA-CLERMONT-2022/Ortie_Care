package com.ipme.ortiecare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Sols")
public class Sol {
	
	@Id
	@Column(name="idSol", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID idSol;
	
	@Column(name="nomSol", length=255)
	private String nomSol;
	
	@Column(name="textureSol", length=255)
	private String textureSol;
	
	@Column(name="structureSol", length=255)
	private String structureSol;
	
	@Column(name="AvantageSol", length=255)
	private String avantageSol;
	
	@Column(name="inconvenientSol", length=255)
	private String inconvenientSol;
	
	
	public Sol(UUID idSol, String nomSol, String textureSol, String structureSol, String avantageSol, String inconvenientSol) {
		
		this.idSol = idSol;
        this.nomSol = nomSol;
        this.textureSol = textureSol;
        this.structureSol = structureSol;
        this.avantageSol = avantageSol;
        this.inconvenientSol= inconvenientSol;
	}
	
	public UUID getId() {
		return this.idSol;
	}

	public String getDescription() {
		return nomSol;
	}

	public void setDescription(String description) {
		this.nomSol = description;
	}

	public String getTextureSol() {
		return textureSol;
	}

	public void setTextureSol(String textureSol) {
		this.textureSol = textureSol;
	}

	public String getStructureSol() {
		return structureSol;
	}

	public void setStructureSol(String structureSol) {
		this.structureSol = structureSol;
	}

	public String getAvantageSol() {
		return avantageSol;
	}

	public void setAvantageSol(String avantageSol) {
		this.avantageSol = avantageSol;
	}

	public String getInconvenientSol() {
		return inconvenientSol;
	}

	public void setInconvenientSol(String inconvenientSol) {
		this.inconvenientSol = inconvenientSol;
	}

}
