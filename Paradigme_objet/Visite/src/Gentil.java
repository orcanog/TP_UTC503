public class Gentil extends Personnage {
    private boolean force;

    public boolean getForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public Gentil(){
        super();
        this.force = true;
    }

    public Gentil(String nom, String prenom, boolean force) {
        super(nom, prenom);
        this.force = force;
    }

    @Override
    public String toString() {
        return super.toString() + ", il fait parti de la force.";
    }
}
