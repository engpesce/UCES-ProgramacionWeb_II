package edu.uces.ar.model;

import javax.persistence.Entity;

@Entity
class Flavor {

	private String name;
	private boolean isDiet;
	
	public Flavor() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDiet() {
		return isDiet;
	}
	public void setDiet(boolean isDiet) {
		this.isDiet = isDiet;
	} 
	
}
