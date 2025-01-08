% Déclaration de faits et règles
homme(pierre).
homme(marc).
homme(paul).
homme(jacques).
femme(marie).
femme(sophie).
femme(julie).

parent(pierre, paul).
parent(marie, paul).
parent(marc, sophie).
parent(jacques, marc).
parent(julie, sophie).

pere(X, Y) :- homme(X), parent(X, Y).
mere(X, Y) :- femme(X), parent(X, Y).

% Règle pour les grands-parents
grandparent(X, Y) :- parent(X, Z), parent(Z, Y).

% Règle pour les frères et soeurs
freresoeur(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

% Règles pour déterminer la longueur d'une liste
longueur([], 0).
longueur([_ | Queue], N) :- longueur(Queue, M), N is M + 1.

% Règles pour vérifier si quelqu'un est dans une liste
estpresent([X | _], X).
estpresent([_ | Queue], X) :- estpresent(Queue, X).

% Règle pour les oncles et tantes
oncletante(X, Y) :- freresoeur(X, Z), parent(Z, Y).

% Règle pour les cousins
cousin(X, Y) :- parent(Z, X), freresoeur(Z, W), parent(W, Y).