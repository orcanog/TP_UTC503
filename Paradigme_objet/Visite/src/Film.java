import javax.lang.model.type.NullType;
import java.util.*;

/**
 * La classe <code>Film</code> représente un film avec son nom, son année de sortie,
 * son numéro d'épisode, son coût de production, ses recettes, et une liste d'acteurs.
 * Elle permet de manipuler ces informations et d'ajouter des acteurs à un film.
 *
 * @author Orcan
 * @version 1.0
 */
public class Film {
    private String nom;
    private String annee_sortie;
    private int numero_episode;
    private int cout;
    private int recette;
    private ArrayList<Acteur> acteurs;

    /**
     * Retourne le nom du film.
     *
     * @return Le nom du film.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du film.
     *
     * @param nom Le nom du film.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'année de sortie du film.
     *
     * @return L'année de sortie du film.
     */
    public String getAnnee_sortie() {
        return annee_sortie;
    }

    /**
     * Définit l'année de sortie du film.
     *
     * @param annee_sortie L'année de sortie du film.
     */
    public void setAnnee_sortie(String annee_sortie) {
        this.annee_sortie = annee_sortie;
    }

    /**
     * Retourne le numéro d'épisode du film.
     *
     * @return Le numéro d'épisode du film.
     */
    public int getNumero_episode() {
        return numero_episode;
    }

    /**
     * Définit le numéro d'épisode du film.
     *
     * @param numero_episode Le numéro d'épisode du film.
     */
    public void setNumero_episode(int numero_episode) {
        this.numero_episode = numero_episode;
    }

    /**
     * Retourne le coût de production du film.
     *
     * @return Le coût de production du film.
     */
    public int getCout() {
        return cout;
    }

    /**
     * Définit le coût de production du film.
     *
     * @param cout Le coût de production du film.
     */
    public void setCout(int cout) {
        this.cout = cout;
    }

    /**
     * Retourne les recettes générées par le film.
     *
     * @return Les recettes générées par le film.
     */
    public int getRecette() {
        return recette;
    }

    /**
     * Définit les recettes générées par le film.
     *
     * @param recette Les recettes générées par le film.
     */
    public void setRecette(int recette) {
        this.recette = recette;
    }

    /**
     * Retourne une chaîne de caractères qui résume les informations du film.
     *
     * @return Un résumé des informations du film.
     */
    @Override
    public String toString() {
        return this.getNom() + " sorti en " + this.getAnnee_sortie() + " est l'épisode n°" + this.getNumero_episode() + " a eu un coût de " + this.getCout() + " et a généré " + this.getRecette() + " de recettes.";
    }

    /**
     * Constructeur par défaut de la classe Film. Initialise les attributs avec des valeurs par défaut.
     */
    public Film() {
        this.nom = "";
        this.annee_sortie = "";
        this.numero_episode = 0;
        this.cout = 0;
        this.recette = 0;
        this.acteurs = new ArrayList<Acteur>();
    }

    /**
     * Constructeur de la classe Film. Initialise un film avec les valeurs spécifiées.
     *
     * @param nom Le nom du film.
     * @param annee_sortie L'année de sortie du film.
     * @param numero_episode Le numéro d'épisode du film.
     * @param cout Le coût de production du film.
     * @param recette Les recettes générées par le film.
     */
    public Film(String nom, String annee_sortie, int numero_episode, int cout, int recette) {
        this.nom = nom;
        this.annee_sortie = annee_sortie;
        this.numero_episode = numero_episode;
        this.cout = cout;
        this.recette = recette;
        this.acteurs = new ArrayList<Acteur>();
    }

    /**
     * Retourne la liste des acteurs du film.
     *
     * @return La liste des acteurs du film.
     */
    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    /**
     * Ajoute un acteur à la liste des acteurs du film.
     *
     * @param nom Le nom de l'acteur.
     * @param prenom Le prénom de l'acteur.
     */
    public void setActeurs(String nom, String prenom) {
        this.acteurs.add(new Acteur(nom, prenom));
    }

    public void setActeurs(ArrayList<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public String nbActeurs(){
        int nb_acteurs = 0;
        for (Acteur acteur : this.acteurs) {
            nb_acteurs = nb_acteurs + 1;
        }
        return "Voici le nombre d'acteurs dans ce film : " + nb_acteurs;
    }

    public String nbPersonnages(){
        int nb_personnages = 0;
        for (Acteur acteur : this.acteurs){
            for (Personnage personnage : acteur.getPersonnages()) {
                nb_personnages = nb_personnages + 1;
            }
        }
        return "Voici le nombre de personnages dans ce film : " + nb_personnages;
    }

    public double calculBenefice(){
        boolean estBeneficiaire;
        if (this.recette - this.cout < 0){
            estBeneficiaire = false;
        } else {
            estBeneficiaire = true;
        }
        if (estBeneficiaire) {
            System.out.print("Le film est bénéficiaire de : ");
        } else {
            System.out.print("Le film est déficitaire de : ");
        }
        return this.recette - this.cout;
    }

    public double calculBeneficeSansPrint(){
        return this.recette - this.cout;
    }

    public boolean isBefore(String annee) {
        int int_annee = Integer.parseInt(annee);
        int int_annee_sortie = Integer.parseInt(this.annee_sortie);
        return int_annee_sortie < int_annee;
    }

    public void tri(ArrayList<Film> films) {
        films.sort(Comparator.comparing(Film::getNom));
    }

    public void makeBackUp(Map<Integer, Film> films) {
        for (Map.Entry<Integer, Film> entry : films.entrySet()) {
            Integer annee = entry.getKey();
            Film film = entry.getValue();
            System.out.println(annee + " - " + film.getNom() + " - " + film.calculBeneficeSansPrint());
        }
    }

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