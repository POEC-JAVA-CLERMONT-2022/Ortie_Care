package com.ipme.ortiecare.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class LegumesConseilsDeCulturePK implements Serializable {
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Legume legume;
	@ManyToOne(fetch=FetchType.LAZY)
	private ConseilDeCulture conseil;
	
	public LegumesConseilsDeCulturePK(Legume legume, ConseilDeCulture conseil)
	{
		this.legume = legume;
		this.conseil = conseil;
	}
	
	public Legume getLegume(){return this.legume;}
	public ConseilDeCulture getConseil(){return this.conseil;}
}
