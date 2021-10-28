# GUIGMA_projet_scala
Ce projet consiste à développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires. 
La tondeuse peut être programmée pour parcourir l'intégralité de la surface. 
La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). 
La pelouse est divisée en grille pour simplifier la navigation.

Pour réaliser cela, nous créeons tout d'abord une classe tondeuse ayant comme attricbuts les coordonnées et l'orientation de la tondeuse 
afin d'initialiser les deux tondeuses qui vont naviguer sur la pelouse. 
Ensuite nous créeons une fonction programme qui prend en arguments les coordonnées de la tondeuse, les instructions de la tondeuse et les coordonnées de la pelouse. 
Cette fonction exécute les intructions d'une tondeuse donnée.

Enfin nous utilisons le fichier text contenu dans les ressources pour extraire les coordonnées des 2 tondeuses ainsi que de la pelouse et les instructions des ces tondeuses. 
Nous appliquons ensuite le programme sur chacune des tondeuses et affichons le résultat.

