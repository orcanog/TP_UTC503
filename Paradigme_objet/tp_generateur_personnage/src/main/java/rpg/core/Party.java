package main.java.rpg.core;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<Character> charactersList = new ArrayList<Character>();

    public void addCharacterToParty(Character character){
        charactersList.add(character);
        System.out.println("Personnage ajouté à l'équipe !");
    }

    public void removeCharacterFromParty(Character character){
        charactersList.removeIf(c -> c.equals(character));
        System.out.println("Personnage supprimé de l'équipe !");
    }

    public int getTotalPowerLevel(){
        int totalPowerLevel = 0;
        for (Character characterIterator : charactersList){
            totalPowerLevel += characterIterator.getPowerLevel();
        } return totalPowerLevel;
    }

}
