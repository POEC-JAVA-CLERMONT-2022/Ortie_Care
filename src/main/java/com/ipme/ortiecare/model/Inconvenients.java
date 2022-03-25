package com.ipme.ortiecare.model;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Inconvenients")
public class Inconvenients {
	
	@Id
	@Column(name = "idInconvenient", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idInconvenient;
	
	@Column(name ="description", length=255)
	private String description;


	public Inconvenients(UUID idInconvenient, String description) {
		this.idInconvenient = idInconvenient;
		this.description = description;
	}
}
