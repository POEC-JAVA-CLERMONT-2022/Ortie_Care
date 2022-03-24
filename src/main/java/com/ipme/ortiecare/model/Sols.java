package com.ipme.ortiecare.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Sols")
public class Sols {
	
	@Id
	@Column(name="idSol", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID idSol;
	
	@Column(name="descriptionSol", length=255)
	private String description;
	
	@Column(name="AvantageSol", length=255)
	private String avantageSol;
	
	@Column(name="InconvenientSol", length=255)
	private String inconvenientSol;
	
	public Sols(UUID idSol, String description, String inconvenientSol, String avantageSol) {
		
		this.idSol = idSol;
        this.description = description;
        this.inconvenientSol= inconvenientSol;
        this.avantageSol = avantageSol;
	}
	
	public UUID getId() {
		return this.idSol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvantage() {
		return avantageSol;
	}

	public void setAvantage(String avantage) {
		this.avantageSol = avantage;
	}

	public String getInconvenient() {
		return inconvenientSol;
	}

	public void setInconvenient(String inconvenient) {
		this.inconvenientSol = inconvenient;
	}	
	
}
