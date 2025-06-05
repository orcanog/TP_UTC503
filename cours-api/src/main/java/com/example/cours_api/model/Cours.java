package com.example.cours_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String matiere;
	private int nbHeures;
	
	public Long getId() {
		return id;
	}
	
	
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	
	
	public int getNbHeures() {
		return nbHeures;
	}
	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}
	
	
	public Cours() {
	}
	
}
