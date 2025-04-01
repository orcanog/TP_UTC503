package main.java.rpg.decorator;

import main.java.rpg.core.Character;

public class Telepathy extends CharacterDecorator {
    public Telepathy(Character character){
        super(character);
    }

    @Override
    public String getDescription(){
        return character.getDescription() + "Ce personnage est télépathe";
    }

    @Override
    public int getPowerLevel(){
        return character.getPowerLevel() + 1;
    }
}
