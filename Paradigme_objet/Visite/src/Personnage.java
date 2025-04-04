public class Personnage {
    private String nom;
    private String prenom;

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
        return "Voici le personnage : " + this.getNom() + " " + this.getPrenom();
    }

    public Personnage() {
        this.nom = "";
        this.prenom = "";
    }

    public Personnage(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
