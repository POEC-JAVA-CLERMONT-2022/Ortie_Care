package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;
//@AssociationOverride(name = "legumes.idLegume", joinColumns = @JoinColumn(name = "legume_id_legume")),
//@AssociationOverride(name = "legumes.conseilsDeCulture", joinColumns = @JoinColumn(name = "conseils_de_culture_id_conseil")), })

@Entity
@Table(name = "legumes_conseils_de_culture")
@AssociationOverrides({
	@AssociationOverride(name = "conseilLegume.legume", joinColumns = @JoinColumn(name = "legume_id_legume")),
	@AssociationOverride(name = "conseilLegume.conseil", joinColumns = @JoinColumn(name = "conseils_de_culture_id_conseil")), })
public class LegumesConseilsDeCulture {

	@EmbeddedId
	private LegumesConseilsDeCulturePK conseilLegume;

	// Constructeur par défaut necessaire pour hibernate
	public LegumesConseilsDeCulture(){	}
	public LegumesConseilsDeCulture(LegumesConseilsDeCulturePK conseilLegume) {
		this.conseilLegume = conseilLegume;
	}
	public LegumesConseilsDeCulturePK getConseilLegume() {
		return conseilLegume;
	}
}
