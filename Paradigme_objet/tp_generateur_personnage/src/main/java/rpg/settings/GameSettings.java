package main.java.rpg.settings;

import main.java.rpg.core.Character;

public class GameSettings {
    public static GameSettings parametres;

    private int maxStatsPoints;

    private GameSettings(){
        this.maxStatsPoints = 200;
    }

    public int getMaxStatsPoints() {
        return maxStatsPoints;
    }

    public boolean isValid(Character character){
        if (character.getPowerLevel() > this.getMaxStatsPoints()){
            return false;
        } else {
            return true;
        }
    }

    public static GameSettings getInstance(){
        if (parametres == null){
            parametres = new GameSettings();
        } return parametres;
    }
}
