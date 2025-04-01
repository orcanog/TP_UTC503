package main.java.rpg.builder;

import main.java.rpg.core.Character;

public class CharacterBuilder {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public CharacterBuilder setName(String name){
        this.name = name;
        return this;
    }

    public String getName(){
        return name;
    }

    public CharacterBuilder setStrength(int strength){
        this.strength = strength;
        return this;
    }

    public int getStrength(){
        return strength;
    }

    public CharacterBuilder setAgility(int agility){
        this.agility = agility;
        return this;
    }

    public int getAgility() {
        return agility;
    }

    public CharacterBuilder setIntelligence(int intelligence){
        this.intelligence = intelligence;
        return this;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getDescription(){
        return "Voici le personnage " + this.getName();
    }

    public Character build(){
        return Character.build(this);
    }
}
