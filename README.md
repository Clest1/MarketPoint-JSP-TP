# MarketPoint-JSP-TP
 Le but de ce cas pratique est de monter en binôme un petit projet JEE complet à base de servlets, JSP, HTML et CSS

## Createur

Giboulot Gabriel alias Clest1
Jovinel Paris alias PJvnl

Réalisé en temps que mini projet JEE le 26/02/2020 au 27/02/2020

## Composition de l'application

### Page principal : accueil

Dès le démarrage de l'application, on arrive sur la page d'accueil.
Elle est composé d'une barre de navigation, avec le nom du site, le lien vers l'accueil et un lien pour se connecter ou créer un compte.
En dessous se trouve deux tableaux, le premier tableau est la liste des articles disponibles.
Et le second tableau est celle des articles composant le panier

Derrière chaque ligne d'article est présent un bouton "+" permettant l'ajout au panier de celui-ci, on peut ajouter plusieurs fois le même objets.
Une fois un objet ajouté, une nouvelle ligne apparaitra dans le panier, un bouton similaire avec un "-" permettra de le retirer du panier.

#### privilège administrateur

Avec les privilèges administrateur, il est possible de créer ou de supprimer des articles.

Pour les supprimer, il suffit de cliquer sur le bouton "supprimer" en bout de ligne de l'article dans le premier tableau de la page principale.
Pour en créer un nouveau, il suffit de remplir le formulaire en dessous de celui-ci et d'appuyer sur le bouton "ajouter" en dessous

### Page secondaires : Inscription et connexion

Il est possible de créer un compte, celui ci ne sera que client, et lie le token du panier local au compte, permettant à l'utilisateur d'y avoir accès en ligne.

Un compte avec des privilèges administrateur est créé au démarrage, l'identifiant est *Clest1* et dont le mot de passe est *1234Test*.
