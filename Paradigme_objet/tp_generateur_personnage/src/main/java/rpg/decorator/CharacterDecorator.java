package main.java.rpg.decorator;

import main.java.rpg.builder.CharacterBuilder;
import main.java.rpg.core.Character;

public abstract class CharacterDecorator extends CharacterBuilder {
    protected Character character;


    public CharacterDecorator(Character character){
        this.character = character;
    }

    public String getDescription(){
        return character.getDescription();
    }

    public int getPowerLevel(){
        return character.getPowerLevel();
    }
}
