% Recettes et leurs ingrédients
ingredient(pizza, farine).
ingredient(pizza, eau).
ingredient(pizza, sel).
ingredient(pizza, levure).
ingredient(pizza, tomate).
ingredient(pizza, fromage).

ingredient(salade, laitue).
ingredient(salade, tomate).
ingredient(salade, concombre).
ingredient(salade, vinaigre).
ingredient(salade, huile).

ingredient(pates_carbonara, pates).
ingredient(pates_carbonara, creme).
ingredient(pates_carbonara, lardons).
ingredient(pates_carbonara, fromage).
ingredient(pates_carbonara, sel).
ingredient(pates_carbonara, poivre).

ingredient(omelette, oeufs).
ingredient(omelette, sel).
ingredient(omelette, poivre).
ingredient(omelette, fromage).

ingredient(sandwich_jambon_beurre, pain).
ingredient(sandwich_jambon_beurre, beurre).
ingredient(sandwich_jambon_beurre, jambon).

ingredient_optionnel(omelette, herbes).
ingredient_optionnel(sandwich_jambon_beurre, salade).

% Vérifie si une recette est possible avec les ingrédients disponibles
peut_preparer(Recette, IngredientsDisponibles) :- forall(ingredient(Recette, Ingredient), member(Ingredient, IngredientsDisponibles)), forall(ingredient_optionnel(Recette, Ingredient), member(Ingredient, IngredientsDisponibles); true).

% Trouve les recettes possibles avec les ingrédients disponibles
recettes_possibles(IngredientsDisponibles, Recette) :- ingredient(Recette, _), peut_preparer(Recette, IngredientsDisponibles).