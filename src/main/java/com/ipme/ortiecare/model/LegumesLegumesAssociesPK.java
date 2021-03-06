package com.ipme.ortiecare.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Lazy;

@SuppressWarnings("serial")
@Embeddable
public class LegumesLegumesAssociesPK implements Serializable {
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Legume legume1;
	@ManyToOne(fetch=FetchType.LAZY)
	private Legume legume2;
	
	// Constructeur par défaut necessaire pour hibernate
	public LegumesLegumesAssociesPK(){	}
	public LegumesLegumesAssociesPK(@Lazy Legume legume1, @Lazy Legume legume2)
	{
		this.legume1 = legume1;
		this.legume2 = legume2;
	}
	
	public Legume getLegume1(){return this.legume1;}
	public Legume getLegume2(){return this.legume2;}

}
