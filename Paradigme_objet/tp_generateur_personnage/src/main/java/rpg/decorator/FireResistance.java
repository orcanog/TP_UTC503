package main.java.rpg.decorator;

import main.java.rpg.core.Character;

public class FireResistance extends CharacterDecorator {
    public FireResistance(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " Ce personnage est résistant au feu.";
    }

    @Override
    public int getPowerLevel() {
        return character.getPowerLevel() + 2;
    }
}
