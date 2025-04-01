package main.java.rpg.main;

import main.java.rpg.builder.CharacterBuilder;
import main.java.rpg.core.Character;
import main.java.rpg.core.Party;
import main.java.rpg.decorator.FireResistance;
import main.java.rpg.decorator.Invisibility;
import main.java.rpg.decorator.Telepathy;
import main.java.rpg.dao.CharacterDAO;

public class Main {
    public static void main(String[] args) {
        // Création de personnages avec le pattern Builder
        Character warrior = new CharacterBuilder()
                .setName("Aragorn")
                .setStrength(8)
                .setAgility(5)
                .setIntelligence(4)
                .build();
        
        Character mage = new CharacterBuilder()
                .setName("Gandalf")
                .setStrength(3)
                .setAgility(4)
                .setIntelligence(9)
                .build();
        
        Character rogue = new CharacterBuilder()
                .setName("Legolas")
                .setStrength(4)
                .setAgility(8)
                .setIntelligence(5)
                .build();
        
        // Affichage des personnages et leur niveau de puissance
        System.out.println("==== Personnages de base ====");
        warrior.getDescription();
        mage.getDescription();
        rogue.getDescription();
        
        // Application des décorations (capacités spéciales)
        System.out.println("\n==== Personnages avec capacités spéciales ====");
        
        // Ajouter la résistance au feu à Gandalf
        mage = new FireResistance(mage).build();
        System.out.println(mage.getDescription());
        System.out.println("Niveau de puissance de " + mage.getName() + " avec résistance au feu: " + 
                           mage.getPowerLevel());
        
        // Ajouter l'invisibilité à Legolas
        rogue = new Invisibility(rogue).build();
        System.out.println(rogue.getDescription());
        System.out.println("Niveau de puissance de " + rogue.getName() + " avec invisibilité: " + 
                           rogue.getPowerLevel());
        
        // Combiner plusieurs décorations
        mage = new Telepathy(mage).build();
        System.out.println("Description: " + mage.getDescription());
        System.out.println("Niveau de puissance de " + mage.getName() + " avec résistance au feu et télépathie: " + 
                           mage.getPowerLevel());
        
        // Créer une équipe
        System.out.println("\n==== Équipe ====");
        Party party = new Party();
        
        party.addCharacterToParty(warrior);
        party.addCharacterToParty(mage);
        party.addCharacterToParty(rogue);
        
        System.out.println("Niveau de puissance total de l'équipe: " + party.getTotalPowerLevel());
        
        // Supprimer un personnage de l'équipe
        party.removeCharacterFromParty(rogue);
        System.out.println("Niveau de puissance total de l'équipe après le départ de " + 
                           rogue.getName() + ": " + party.getTotalPowerLevel());
        
        // Utilisation du DAO pour sauvegarder et retrouver des personnages
        System.out.println("\n==== Persistance des données ====");
        CharacterDAO characterDAO = new CharacterDAO();
        
        // Sauvegarde des personnages
        characterDAO.save(warrior);
        characterDAO.save(mage);
        characterDAO.save(rogue);
        
        // Recherche d'un personnage par son nom
        Character foundCharacter = characterDAO.findByName("Gandalf");
        if (foundCharacter != null) {
            System.out.println("Personnage trouvé: " + foundCharacter.getName());
            System.out.println("Niveau de puissance: " + foundCharacter.getPowerLevel());
        }
        
        // Afficher tous les personnages sauvegardés
        System.out.println("\nTous les personnages sauvegardés:");
        for (Character character : characterDAO.findAll()) {
            System.out.println("- " + character.getName() + " (Puissance: " + character.getPowerLevel() + ")");
        }
    }
}
