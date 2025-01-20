recettes = {
    "pizza": {"farine", "eau", "sel", "levure", "tomate", "fromage"},
    "salade": {"laitue", "tomate", "concombre", "vinaigre", "huile"},
    "pâtes carbonara": {"pâtes", "lardons", "crème", "sel", "fromage", "poivre"},
    "omelette": {"œufs", "fromage", "sel", "poivre", "herbes"},
    "sandwich jambon-beurre": {"pain", "jambon", "beurre", "salade"},
}


facultatifs = {
    "omelette": {"herbes"},
    "sandwich jambon-beurre": {"salade"},
}


def recettes_realisables(ingredients_disponibles, recettes):
    return filter(
        lambda recette: (
            recettes[recette]
            .difference(facultatifs.get(recette, set()))
            .issubset(ingredients_disponibles)
        ),
        recettes
    )


ingredients_disponibles = {"farine", "eau", "sel", "levure", "fromage", "tomate", "œufs", "poivre"}


recettes_possibles = recettes_realisables(ingredients_disponibles, recettes)

print("Recettes réalisables :")
for recette in recettes_possibles:
    print(recette)