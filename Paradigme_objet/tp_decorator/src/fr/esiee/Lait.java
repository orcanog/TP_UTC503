package fr.esiee;

// Classe fille pour le supplément Lait

public class Lait extends Decorateur {
    public Lait(Boisson boisson) {
        super(boisson);
    }

    @Override
    public String description() {
        return boisson.description() + " avec lait";
    }

    @Override
    public double cout() {
        return boisson.cout() + 0.5;
    }
}
