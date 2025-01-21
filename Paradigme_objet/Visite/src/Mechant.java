public class Mechant extends Personnage {
    private boolean cote_obscur;

    public boolean getCote_obscur() {
        return cote_obscur;
    }

    public void setCote_obscur(boolean cote_obscur) {
        this.cote_obscur = cote_obscur;
    }

    public Mechant() {
        super();
        this.cote_obscur = true;
    }

    public Mechant(String nom, String prenom, boolean cote_obscur) {
        super(nom, prenom);
        this.cote_obscur = cote_obscur;
    }

    @Override
    public String toString() {
        return super.toString() + ", il fait parti du côté obscur.";
    }
}
