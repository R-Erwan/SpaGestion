# SPA Gestion

**SPA Gestion** est un logiciel conçu pour les employés, bénévoles et administrateurs d'une SPA. Ce logiciel offre une interface utilisateur intuitive pour gérer les animaux, les fiches de soins et les stocks de nourriture. Il vise à faciliter les opérations internes tout en offrant un suivi précis des besoins des animaux.

## Fonctionnalités principales

- **Gestion des animaux** :
  - Ajout, modification et suppression d'animaux.
  - Consultation des fiches détaillées de chaque animal.
- **Fiches de soins** :
  - Création et mise à jour des fiches de soins pour chaque animal.
  - Historique des soins pour un suivi optimal.
- **Gestion des stocks de nourriture** :
  - Ajout et suppression des types de nourriture.
  - Alertes en cas de seuil critique pour éviter les ruptures de stock.

## Technologies utilisées

- **Langage principal** : Java
- **Interface utilisateur** : Java Swing
- **Gestion de projet** : Maven
- **Tests unitaires** : JUnit 5, Mockito

## Installation

1. **Cloner le dépôt** :
   ```bash
   git clone <URL_DU_DEPOT>
   cd spa-gestion
   ```

2. **Construire le projet** :
   Assurez-vous d'avoir [Maven](https://maven.apache.org/) installé, puis exécutez :
   ```bash
   mvn clean install
   ```

3. **Exécuter l'application** :
   L'application n'est pas encore distribuée sous forme d'exécutable. Vous pouvez cependant exécuter la classe principale à partir de votre IDE ou via Maven :
   ```bash
   mvn exec:java -Dexec.mainClass="com.spa.gestion.Main"
   ```

## Tests

Les tests unitaires peuvent être exécutés avec Maven :
```bash
mvn test
```

## Structure du projet

Voici un aperçu de l'organisation des fichiers et des packages principaux :

```
spa-gestion/
├── src/main/java/com.ufrsciencetech/
│   ├── animaux/        # Gestion des animaux
│   ├── soins/         # Gestion des fiches de soins
│   ├── stock/          # Gestion des stocks de nourriture
│   ├── ihm/             # Interface utilisateur (Java Swing)
│   └── Main.java       # Classe principale
├── src/test/java/com.ufrsciencetech/ # Tests unitaires
├── pom.xml             # Fichier de configuration Maven
└── README.md           # Documentation
```

## Auteurs

- **Équipe Projet Universitaire**

