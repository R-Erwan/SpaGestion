# SpaGestion 

## Commencer sur votre branch : 
Cloner le dépot avec **git clone**. \
Faite un **git fetch origin** pour récupérer toutes les branches distantes \
Normalement **git branch -a** devrait afficher quelque chose comme cela :
```
*  main
  remotes/origin/feature/animaux
  remotes/origin/feature/ihm
  remotes/origin/feature/soins
  remotes/origin/feature/stock
  remotes/origin/main
```
En fonction de la branch ou vous devez travailler faites : **git checkout -b feature/stock origin/feature/stock** \
Cela créer une branch local lié a la branch distantes sur laquel travailler. \
Si vous refaite **git branch -a** vosu devrier alors avoir ceci :
```
* feature/stock
  main
  remotes/origin/feature/animaux
  remotes/origin/feature/ihm
  remotes/origin/feature/soins
  remotes/origin/feature/stock
  remotes/origin/main
```
Ensuite quand vous voulez push votre travail vous pouvez faire comme vous savez le faire, toujour sur votre branch.
En faisait des commit, et des push. \
**JAMAIS PUSH SUR LA MAIN ! <3**
