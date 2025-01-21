import java.util.ArrayList;

public class Acteur {
    private String nom;
    private String prenom;
    private ArrayList<Personnage> personnages;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Voici l'acteur : " + this.getNom() + " " + this.getPrenom();
    }

    public Acteur() {
        this.nom = "";
        this.prenom = "";
        this.personnages = new ArrayList<Personnage>();
    }

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.personnages = new ArrayList<Personnage>();
    }

    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(String nom, String prenom) {
        this.personnages.add(new Personnage(nom, prenom));
    }

    public void setPersonnagesGentils(String nom, String prenom, boolean force) {
        this.personnages.add(new Gentil(nom, prenom, force));
    }

    public void setPersonnagesMechants(String nom, String prenom, boolean cote_obscur) {
        this.personnages.add(new Mechant(nom, prenom, cote_obscur));
    }

    public String nbPersonnages(){
        int nb_personnages = 0;
        for (Personnage personnage : this.personnages) {
            nb_personnages = nb_personnages + 1;
        }
        return "Voici le nombre de personnages joués par cet acteur : " + nb_personnages;
    }
}
