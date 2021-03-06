package com.ipme.ortiecare.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "legumes_legumes_associes")
@AssociationOverrides({
		@AssociationOverride(name = "assoLegumes.legume1", joinColumns = @JoinColumn(name = "legume_id_legume")),
		@AssociationOverride(name = "assoLegumes.legume2", joinColumns = @JoinColumn(name = "legumes_associes_id_legume")), })
public class LegumesLegumesAssocies {
	
	@EmbeddedId
	private LegumesLegumesAssociesPK assoLegumes;
	

	// Constructeur par défaut necessaire pour hibernate
	public LegumesLegumesAssocies(){	}
	public LegumesLegumesAssocies(LegumesLegumesAssociesPK assoLegumes) {
		this.assoLegumes = assoLegumes;
	}

	public LegumesLegumesAssociesPK getAssoLegumes() {
		return assoLegumes;
	}
	
}
