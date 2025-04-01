package main.java.rpg.dao;

import java.util.ArrayList;
import java.util.List;
import main.java.rpg.core.Character;

public class CharacterDAO implements DAO<Character> {
    private List<Character> charactersList = new ArrayList<Character>();

    @Override
    public void save(Character character){
        charactersList.add(character);
        System.out.println("Sauvegardé !");
    }

    @Override
    public Character findByName(String name) {
        for (Character characterToFind : charactersList) {
            if (characterToFind.getName() != null && characterToFind.getName().equals(name)) {
                System.out.println("Trouvé !");
                return characterToFind;
            }
        }
        return null;
    }

    @Override
    public List<Character> findAll(){
        return charactersList;
    }
}
