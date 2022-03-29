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
	
	@Column(name="proprieteSol", length=255)
	private String proprieteSol;
	
	
	public Sols(UUID idSol, String description, String proprieteSol) {
		
		this.idSol = idSol;
        this.description = description;
        this.proprieteSol= proprieteSol;
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

	public String getProprieteSol() {
		return proprieteSol;
	}

	public void setProprieteSol(String avantage) {
		this.proprieteSol = avantage;
	}

	
}
