from dataclasses import dataclass
import random
import asyncio

# Exercice 1
liste_nombres = [1, 2, 3, 4, 5, 1, 1, 1]
def addToEach(n, liste):
    return [x + n for x in liste]
nouvelle_liste = addToEach(3, liste_nombres)
print(nouvelle_liste)

def removeDuplicates(liste):
    return list(dict.fromkeys(liste))

print(removeDuplicates(liste_nombres))

# Exercice 2
@dataclass(frozen=True)
class Personne:
    nom: str
    age: int

p1 = Personne("Jean", 20)
p2 = Personne("Laura", 19)
p3 = Personne("Jae", 27)
p4 = Personne("Alex", 23)

liste_personnes = [p1, p2, p3, p4]

def anniversaire(liste):
    return [Personne(x.nom, x.age+1) for x in liste]

print(anniversaire(liste_personnes))


async def getRandomNumber():
    await asyncio.sleep(1)
    return random.randint(1, 100)

async def main():
    nombre1_future = asyncio.create_task(getRandomNumber())
    nombre2_future = asyncio.create_task(getRandomNumber())

    nombre1 = await nombre1_future
    nombre2 = await nombre2_future

    print(nombre1)
    print(nombre2)

# Exercice 3
@dataclass(frozen=True)
class Article:
    nom: str
    prix: int
    qte: int

inventaire = []

def ajouterArticle(inventaire, nom, prix, qte):
    return inventaire.append(Article(nom, prix, qte))

def supprimerArticle(inventaire, nom):
    return inventaire.remove(nom)

def majQteArticle(inventaire, nom, qte):
    for x in inventaire:
        if inventaire[x.nom] == inventaire[nom]:
            inventaire.append(x.nom, x.prix, qte)
            inventaire.remove(x)
            return inventaire

class Commande:
    liste_article: list

def prixTotal(commande):
    for article in commande.liste_article:
        prixTotal += commande.liste_article[article]
        return prixTotal


class Promotion:
    nom: str
    condition: bool
    reduction: int

def prixTotalSolde(commande, promotion):
    if prixTotal(commande) > 10:
        promotion.condition = True
    if promotion.condition:
        prixAvantReduc = prixTotal(commande)
        prixPostReduc = prixAvantReduc - (prixAvantReduc * promotion.reduction)
        return prixPostReduc
    
liste_commandes = []

def traitementStock(commandes):
    for commande in commandes:
        for article in commande.liste_article:
            majQteArticle(inventaire, article.nom, article.qte)
            return inventaire


if __name__ == "__main__":
    asyncio.run(main())