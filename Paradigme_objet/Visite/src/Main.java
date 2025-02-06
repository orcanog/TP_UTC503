import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Un nouvel espoir", "1977", 4, 1900, 292);
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez donner le nom du film à ajouter :");
        String nom = sc.nextLine();
        System.out.println("Veuillez donner son année de sortie :");
        String annee_sortie = sc.nextLine();
        System.out.println("Veuillez donner le numéro de l'épisode :");
        int numero_episode = sc.nextInt();
        System.out.println("Veuillez donner le coût de production du film :");
        int cout = sc.nextInt();
        System.out.println("Veuillez donner les recettes du film :");
        int recette = sc.nextInt();
        Film film2 = new Film(nom, annee_sortie, numero_episode, cout, recette);

        Personnage perso1 = new Personnage("Tanguy", "Hugo");

        film1.setActeurs("Legrand", "Hugo");
        film1.setActeurs("Lepetit", "Jean");
        film1.setActeurs("Loea", "Lea");

        System.out.println(film1.getActeurs());

        Acteur acteur1 = new Acteur("Lilit", "Mona");
        acteur1.setPersonnages("Gromit", "Lefou");
        acteur1.setPersonnages("Moonlight", "Escalibur");

        System.out.println(acteur1.nbPersonnages());

        film2.setActeurs(film1.getActeurs());

        System.out.println(film1.nbActeurs());


    }
}
