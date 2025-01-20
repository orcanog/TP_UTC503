recettes = {
    "pizza": {"farine", "eau", "sel", "levure", "tomate", "fromage"},
    "salade": {"laitue", "tomate", "concombre", "vinaigre", "huile"},
    "pâtes carbonara": {"pâtes", "lardons", "crème", "sel", "fromage", "poivre"},
    "omelette": {"œufs", "fromage", "sel", "poivre", "herbes"},
    "sandwich jambon-beurre": {"pain", "jambon", "beurre", "salade"},
}

def recettes_possibles(ingredients_disponible):
    recettes_possibles = set()
    for recette, ingredients in recettes.items():
        if ingredients.issubset(ingredients_disponible):
            recettes_possibles.add(recette)
    return recettes_possibles

ingredients_disponible = {"farine", "eau", "sel", "levure", "tomate", "fromage"}
print(recettes_possibles(ingredients_disponible))

ingredients_disponible = {"laitue", "tomate", "concombre", "vinaigre", "huile"}
print(recettes_possibles(ingredients_disponible))