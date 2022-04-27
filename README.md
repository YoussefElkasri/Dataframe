# Dataframe
[![GitHub issues](https://img.shields.io/github/issues/YoussefElkasri/Dataframe)](https://github.com/YoussefElkasri/Dataframe/issues)
[![GitHub forks](https://img.shields.io/github/forks/YoussefElkasri/Dataframe)](https://github.com/YoussefElkasri/Dataframe/network)
![GitHub repo size](https://img.shields.io/github/repo-size/YoussefElkasri/Dataframe)
![CodeFactor Grade](https://img.shields.io/codefactor/grade/github/YoussefElkasri/Dataframe)
![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)


Dans cette page on va essayer de valoriser notre bibliotheque qui est developpé par un groupe des etudiants de l'UGA qui sont : <br />
### <i> El kasri Youssef </i>
### <i> Mattiche Othmane </i>
### <i> Ran Cheng </i>

## Choix d'outils
  <ul><li>Github : Pour le dépot distant </li>
  <li>Maven : pour automatiser les tâches de compilation, tests unitaires et déploiement des applications qui composent le projet </li>
  <li>Jacoco : pour le code coverage </li>
  <li>Code factor(REVUE DE CODE AUTOMATISÉE POUR GIT) : nous avons l'utilisé pour avoir une bonne qualité de code </li></ul>

## Fonctionnalités de la bibliotheque 

  Notre bibliotheque [DataFrame](https://github.com/YoussefElkasri/Dataframe) contient plusieurs fonctionnalités qui sont :
## Création du dataframe
  <ul><li>A partir d'un fichier csv </li>
  <li>En entrant un tableau des données </li></ul>

## Insertion de données
  <ul><li>Inserer une nouvelle ligne </li>
  <li>Inserer une nouvelle colonne </li></ul>

## Affichage 
  <ul><li>Afficher les n derniers lignes <br />
  <li>Afficher les n premiers lignes </li></ul>

## JavaDoc
  Pour JavaDoc nous l'avons l'heberger avec le site web cree sur github [JavaDoc](https://youssefelkasri.github.io/Dataframe/GroupeY/package-summary.html)
## Operations arithmetique 
  <ul><li>Calcule de la somme d'une colonne </li>
  <li>Calcule de la moyenne des éléments d'une colonne </li> 
  <li>Calcule du minimum et du maximum des éléments d'une colonne </li>
  <li>Calcule de la valeur absolue des éléments d'une colonne</li></ul>
 
 ## Workflow git / pull request
 Nous avons crée une nouvelle branche qui s'appelle premain où tout les push seront efféctués, seule les vérsions stables seront ensuite poussées dans main, ce qui signifie ce que on lance un pull request de premain vers main pour pusher que les commits corrects <br />
 Le workflow lance une liste de job : <br />
    <ul><li>Des tests seront lancés automatiquement </li>
    <li>L'image docker sera mise à jour  </li>
    <li>Calcule de la couverture du code</li></ul>

## Docker
  Aprés chaque push dans le main une image docker sera automatiquement mise à jour <br />
  [Lien de dépot de docker](https://hub.docker.com/repository/docker/19982001/dataframe_2022)
  
## Feedback
  Ce projet nous a permis d'apprendre la bonne méthode pour travailler en groupe, en utilisant les nouvelles fonctionnalités d'intégration et livraison continue, nous  avons bien appris comment on peut utiliser Maven qui permet de faciliter et d'automatiser certaines tâches de la gestion d'un projet Java, nous avons appris comment on peut faire la livraison continue avec docker, et beaucoup des autres choses.
  En effet c'est une bonne experience de travail collaboratif qui va nous aider dans le futur.
