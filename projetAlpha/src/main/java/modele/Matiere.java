package modele;

public class Matiere {
	
	private int id;
	private String nom;
	private int heure;
	
	
	
	public Matiere(int id, String nom, int heure) {
		this.id = id;
		this.nom = nom;
		this.heure = heure;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getHeure() {
		return heure;
	}



	public void setHeure(int heure) {
		this.heure = heure;
	}



	public int getId() {
		return id;
	}
}