# Partie 1

liste_noms = []
liste_notes = []

# Partie 2
def calculer_moyenne(liste_notes):
    return sum(liste_notes) / len(liste_notes)

# Partie 3
def afficher_repartition(noms, notes):
    liste_eleves_reussi = []
    liste_eleves_echec = []
    for i in range(len(noms)):
        if notes[i] < 10:
            liste_eleves_echec.append(noms[i])
        elif notes[i] >= 10:
            liste_eleves_reussi.append(noms[i])
    print(f"Étudiants ayant réussi : {', '.join(liste_eleves_reussi)}")
    print(f"Étudiants en échec : {', '.join(liste_eleves_echec)}")

# Partie 4
def meilleure_note(noms, notes):
    meilleure_note = max(notes)
    index = notes.index(meilleure_note)
    meilleur_etudiant = noms[index]
    print(f"L'étudiant ayant eu la meilleure note est {meilleur_etudiant} avec {meilleure_note}.")

# Partie extension
def trier_ordre_decroissant(noms, notes):
    liste_notes_decroissant = sorted(notes, reverse=True)
    liste_etudiants_decroissant = []
    for i in range(len(liste_notes_decroissant)):
        liste_etudiants_decroissant.append([noms[notes.index(liste_notes_decroissant[i])], liste_notes_decroissant[i]])
    return liste_etudiants_decroissant


# Main Partie 1
print("Combien d'étudiants souhaitez-vous saisir ?")
nb_etudiants = int(input())
for i in range(nb_etudiants):
    print(f"Nom de l'étudiant {i + 1} : ")
    nom = input()
    liste_noms.append(nom)
    print(f"Note de {nom} : ")
    note = int(input())
    liste_notes.append(note)
print(len(liste_noms))
test = sum(liste_notes) / len(liste_notes)
print(test)
moyenne = calculer_moyenne(liste_notes)
# Afficher la moyenne (partie 2)
print(f"La moyenne de la classe est de {moyenne}.")
afficher_repartition(liste_noms, liste_notes)
meilleure_note(liste_noms, liste_notes)
# Partie extension
etudiant_decroissant = trier_ordre_decroissant(liste_noms, liste_notes)
print("Voici la liste des étudiants par ordre décroissant de notes :")
for i, j in etudiant_decroissant:
    print(f"{i} : {j}")
menu = True
while menu:
    print("Souhaitez-vous rechercher un élève ? (O/N)")
    choix = input()
    if choix == "O":
        print("Entrez le nom de l'étudiant : ")
        nom = input()
        if nom in liste_noms:
            print(f"{nom} a eu {liste_notes[liste_noms.index(nom)]}.")
        else:
            print(f"{nom} n'a pas été trouvé.")
    elif choix == "N":
        menu = False
    else:
        print("Veuillez entrer une réponse valide.")