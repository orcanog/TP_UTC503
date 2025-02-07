from functools import reduce

# Exercice 1
square = lambda x: x**2
print(square(3))

liste_nombre = [1, 2, 3, 4, 5]
square_list = list(map(square,liste_nombre))
print(square_list)

somme = lambda a, b: a+b
print(somme(10,8))

somme_list = reduce(somme, liste_nombre)
print(somme_list)


# Exercice 2
def create_multiplier(n):
    return lambda x: x*n

double = create_multiplier(2)
triple = create_multiplier(3)

print(double(80))
print(triple(21))

print(double(12231))
print(triple(3231))


# Exercice 3
liste_mots = ["Voici", "une", "liste", "de", "avocat", "mots", "complète", "", "", "averse"]
liste_mots_filtres = list(filter(lambda x: x.startswith("a"), liste_mots))
print(liste_mots_filtres)

liste_mots_cinq = list(filter(lambda x: len(x) > 5, liste_mots))
print(liste_mots_cinq)


# Exercice 5
def compose(f, g):
    return lambda x: f(g(x))

composed_function = compose(double, triple)
print(composed_function(3))
print(composed_function(79))


# Exercice 6
def filterMap(filter_func, map_func, list):
    return [map_func(x) for x in list if filter_func(x)]

resultat = filterMap(lambda x: x != "", lambda x: x.upper(), liste_mots)
print(resultat)


# Exercice 7
def memoize(func):
    cache = {}
    def wrapper(n):
        if n not in cache:
            cache[n] = func(n)
        return cache[n]
    return wrapper

@memoize
def factoriel(n):
    if n <= 1:
        return 1
    return n * factoriel(n-1)

print(factoriel(0))
print(factoriel(5))

@memoize
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

print(fibonacci(10))


# Exercice 8
liste_produits = {
    "salade" : 5,
    "tomate" : 3,
    "bille" : 1,
    "PS5" : 500
}
def reduction(n):
    return lambda x: x - (x * n)
def calculateDiscount(produits, pourcentage_reduction):
    solde = reduction(pourcentage_reduction)
    prix_reduits = map(solde, produits.values())
    return reduce(lambda x, y: x + y, prix_reduits)

print(calculateDiscount(liste_produits, 0.20))