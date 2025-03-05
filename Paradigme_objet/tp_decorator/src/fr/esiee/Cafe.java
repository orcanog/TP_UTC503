package fr.esiee;

// Class Cafe simple

public class Cafe implements Boisson {
    @Override
    public String description() {
        return "Café";
    }

    @Override
    public double cout() {
        return 1.9;
    }
}