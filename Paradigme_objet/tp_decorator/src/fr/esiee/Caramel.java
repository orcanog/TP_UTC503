package fr.esiee;

// Classe fille pour le supplément caramel

public class Caramel extends Decorateur {
    public Caramel(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String description() {
        return boisson.description() + " avec caramel";
    }

    @Override
    public double cout() {
        return boisson.cout() + 0.2;
    }
}
