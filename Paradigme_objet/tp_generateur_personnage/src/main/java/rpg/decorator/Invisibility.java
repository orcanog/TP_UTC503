package main.java.rpg.decorator;

import main.java.rpg.core.Character;

public class Invisibility extends CharacterDecorator {
    public Invisibility(Character character) {
        super(character);
    }

    @Override
    public String getDescription(){
        return character.getDescription() + "Ce personnage est invisible";
    }

    @Override
    public int getPowerLevel(){
        return character.getPowerLevel() + 3;
    }
}