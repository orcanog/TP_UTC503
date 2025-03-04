package fr.esiee;

public class Main {
    public static void main(String[] args) {
        CommandeCafe commande1 = new CommandeCafe.ConstructeurCommande("Expresso")
                .extraChantilly(true)
                .creer();

        CommandeCafe commande2 = new CommandeCafe.ConstructeurCommande("Gourmand")
                .definirTypeLait("Mousseux")
                .definirQteSucre(3)
                .extraChantilly(true)
                .extraCaramel(true)
                .creer();

        CommandeCafe commandeClientMystere = new CommandeCafe.ConstructeurCommande("Latte")
                .definirTypeLait("Mousseux")
                .definirQteSucre(1)
                .creer();

        commande1.afficherCommande();
        System.out.println("-------------------------------------");
        commande2.afficherCommande();
        System.out.println("-------------------------------------");
        commandeClientMystere.afficherCommande();
        System.out.println("-------------------------------------");

        CommandeThe commandeTheErreur = new CommandeThe.ConstructeurCommandeThe("Thé Vert")
                .extraMiel(true)
                .extraCitron(true)
                .creer();

        try {
            commandeTheErreur.afficherCommande();
        } catch (NullPointerException a) {
            System.out.println("Commande impossible");
            System.out.println("-------------------------------------");
        }

        CommandeThe commandeThe1 = new CommandeThe.ConstructeurCommandeThe("Thé Vert")
                .extraMiel(false)
                .extraCitron(true)
                .creer();

        commandeThe1.afficherCommande();
    }
}
