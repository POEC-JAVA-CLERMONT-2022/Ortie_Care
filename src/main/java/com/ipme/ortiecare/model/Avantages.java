package com.ipme.ortiecare.model;

public class Avantages {

	private int id;
	private String description;

	public Avantages(int id, String description) {

		this.id = id;
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

}
