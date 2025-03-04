package fr.esiee;

public class CommandeCafe {
    private String typeCafe;
    private String typeLait;
    private int qteSucre;
    private boolean chantilly;
    private boolean caramel;

    private CommandeCafe(ConstructeurCommande contructeur) {
        this.typeCafe = contructeur.typeCafe;
        this.typeLait = contructeur.typeLait;
        this.qteSucre = contructeur.qteSucre;
        this.chantilly = contructeur.chantilly;
        this.caramel = contructeur.caramel;
    }

    public void afficherCommande() {
        System.out.println("Voici la commande " + this);
        System.out.println("Type de café : " + typeCafe);
        if (typeLait != null) {
            System.out.println("Type de lait : " + typeLait);
        }
        System.out.println("Quantité de sucre : " + qteSucre);
        if (chantilly) {
            System.out.println("Avec extra chantilly");
        }
        if (caramel) {
            System.out.println("Avec extra caramel");
        }
    }

    public static class ConstructeurCommande {
        private String typeCafe;
        private String typeLait;
        private int qteSucre;
        private boolean chantilly;
        private boolean caramel;

        public ConstructeurCommande(String typeCafe) {
            this.typeCafe = typeCafe;
        }

        public ConstructeurCommande definirTypeLait(String typeLait) {
            this.typeLait = typeLait;
            return this;
        }

        public ConstructeurCommande definirQteSucre(int qteSucre) {
            this.qteSucre = qteSucre;
            return this;
        }

        public ConstructeurCommande extraChantilly(boolean chantilly) {
            this.chantilly = chantilly;
            return this;
        }

        public ConstructeurCommande extraCaramel(boolean caramel) {
            this.caramel = caramel;
            return this;
        }

        public CommandeCafe creer() {
            return new CommandeCafe(this);
        }

    }
}
