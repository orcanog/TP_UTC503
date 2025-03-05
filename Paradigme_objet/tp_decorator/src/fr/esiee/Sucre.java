package fr.esiee;

// Classe fille pour le supplément sucre

public class Sucre extends Decorateur {
    public Sucre(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String description() {
        return boisson.description() + " avec sucre";
    }

    @Override
    public double cout() {
        return boisson.cout() + 0.1;
    }
}
