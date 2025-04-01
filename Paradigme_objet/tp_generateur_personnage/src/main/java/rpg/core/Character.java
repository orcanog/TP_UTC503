package main.java.rpg.core;

import main.java.rpg.builder.CharacterBuilder;

public class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public int getPowerLevel(){
        return strength + agility + intelligence;
    }

    public String getDescription(){
        return "Voici le personnage " + this.getName();
    }

    private Character(CharacterBuilder character){
        this.name = character.getName();
        this.strength = character.getStrength();
        this.agility = character.getAgility();
        this.intelligence = character.getIntelligence();
    }

    public static Character build(CharacterBuilder character) {
        return new Character(character);
    }

    public String getName() {
        return name;
    }
}
