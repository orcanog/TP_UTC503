package fr.esiee;

public class CommandeThe {
    private String typeThe;
    private String typeLait;
    private int qteSucre;
    private boolean miel;
    private boolean citron;

    private CommandeThe(ConstructeurCommandeThe contructeur) {
        this.typeThe = contructeur.typeThe;
        this.typeLait = contructeur.typeLait;
        this.qteSucre = contructeur.qteSucre;
        this.miel = contructeur.miel;
        this.citron = contructeur.citron;
    }

    public void afficherCommande() {
        System.out.println("Voici la commande " + this);
        System.out.println("Type de café : " + typeThe);
        if (typeLait != null) {
            System.out.println("Type de lait : " + typeLait);
        }
        System.out.println("Quantité de sucre : " + qteSucre);
        if (miel) {
            System.out.println("Avec extra miel");
        }
        if (citron) {
            System.out.println("Avec extra citron");
        }
    }

    public static class ConstructeurCommandeThe {
        private String typeThe;
        private String typeLait;
        private int qteSucre;
        private boolean miel;
        private boolean citron;

        public ConstructeurCommandeThe(String typeThe) {
            this.typeThe = typeThe;
        }

        public ConstructeurCommandeThe definirTypeLait(String typeLait) {
            this.typeLait = typeLait;
            return this;
        }

        public ConstructeurCommandeThe definirQteSucre(int qteSucre) {
            this.qteSucre = qteSucre;
            return this;
        }

        public ConstructeurCommandeThe extraMiel(boolean miel) {
            this.miel = miel;
            return this;
        }

        public ConstructeurCommandeThe extraCitron(boolean citron) {
            this.citron = citron;
            return this;
        }

        public CommandeThe creer() {
            if ((this.miel && !this.citron) || (!this.miel && this.citron)) {
                return new CommandeThe(this);
            }
            System.out.println("Impossible de créer votre Thé car vous y avez mit du miel et du citron");
            return null;
        }

    }
}