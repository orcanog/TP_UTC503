package fr.esiee;

public class Main {
    public static void main(String[] args) {

        // Café avec lait et caramel
        Boisson cafe1 = new Cafe();
        cafe1 = new Lait(cafe1);
        cafe1 = new Caramel(cafe1);

        System.out.println(cafe1.description() + " -> " + cafe1.cout() + "€");

        //Café avec sucre et caramel
        Boisson cafe2 = new Cafe();
        cafe2 = new Sucre(cafe2);
        cafe2 = new Caramel(cafe2);

        System.out.println(cafe2.description() + " -> " + cafe2.cout() + "€");


        //Café avec lait et sucre
        Boisson cafe3 = new Cafe();
        cafe3 = new Lait(cafe3);
        cafe3 = new Sucre(cafe3);

        System.out.println(cafe3.description() + " -> " + cafe3.cout() + "€");


        // Café avec lait, sucre et caramel
        Boisson cafe4 = new Cafe();
        cafe4 = new Lait(cafe4);
        cafe4 = new Sucre(cafe4);
        cafe4 = new Caramel(cafe4);

        System.out.println(cafe4.description() + " -> " + cafe4.cout() + "€");
    }
}
