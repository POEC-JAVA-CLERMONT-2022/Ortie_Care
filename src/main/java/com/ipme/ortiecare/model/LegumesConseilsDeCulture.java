package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "legumes_conseils_de_culture")
@AssociationOverrides({
		@AssociationOverride(name = "legumes.idLegume", joinColumns = @JoinColumn(name = "legume_id_legume")),
		@AssociationOverride(name = "legumes.legumesAssocies", joinColumns = @JoinColumn(name = "conseils_de_culture_id_conseil")), })
public class LegumesConseilsDeCulture {

	@Column(name = "legume_id_legume")
	private UUID idLegume;

	@Column(name = "conseils_de_culture_id_conseil")
	private UUID idConseil;

	public LegumesConseilsDeCulture(UUID idLegume, UUID idConseil) {
		
		this.idLegume = idLegume;
		this.idConseil = idConseil;
	}

}
