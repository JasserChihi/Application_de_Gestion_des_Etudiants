# Application de Gestion des Étudiants

Ce dépôt contient un projet complet de développement d'une application de gestion des étudiants, utilisant **JavaFX** pour l’interface utilisateur et **PostgreSQL** pour la gestion de la base de données.

## Table des matières

- [Présentation](#présentation)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Configuration de la base de données](#configuration-de-la-base-de-données)
- [Utilisation](#utilisation)
- [Captures d'écran](#captures-décran)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Présentation

L’application permet de gérer efficacement les informations des étudiants d’un établissement (ajout, modification, suppression, recherche, etc.) grâce à une interface graphique conviviale et une base de données robuste.

## Fonctionnalités

- Authentification des utilisateurs (connexion/sécurité)
- Gestion des étudiants (ajout, modification, suppression, consultation)
- Recherche avancée par critères (nom, filière, etc.)
- Gestion des notes et des résultats
- Exportation des données (PDF, Excel…)
- Interface intuitive et réactive avec JavaFX

## Technologies utilisées

- **Java** (backend et logique métier)
- **JavaFX** (interface graphique)
- **PostgreSQL** (base de données relationnelle)
- **JDBC** (connexion à la base de données)
- [Autres bibliothèques utiles à préciser selon votre projet]

## Installation

1. **Cloner le dépôt**
   ```bash
   git clone https://github.com/JasserChihi/Application_de_Gestion_des_Etudiants.git
   ```
2. **Ouvrir le projet dans votre IDE Java préféré** (IntelliJ IDEA, Eclipse, NetBeans, etc.)
3. **Installer les dépendances** JavaFX et JDBC si elles ne sont pas incluses.

## Configuration de la base de données

1. Installer PostgreSQL si ce n’est pas déjà fait.
2. Créer une base de données, par exemple :
   ```sql
   CREATE DATABASE gestion_etudiants;
   ```
3. Importer le schéma SQL fourni dans le dossier `/sql` (ou à préciser).
4. Configurer les paramètres de connexion dans le fichier de configuration Java :
   ```java
   // Exemple de configuration
   String url = "jdbc:postgresql://localhost:5432/gestion_etudiants";
   String user = "votre_utilisateur";
   String password = "votre_motdepasse";
   ```

## Utilisation

1. Lancer l’application via votre IDE ou depuis la ligne de commande :
   ```bash
   java -jar ApplicationDeGestionDesEtudiants.jar
   ```
2. Connectez-vous avec vos identifiants.
3. Commencez à gérer les étudiants.

---

**Auteur :** Jasser Chihi  
Pour toute question, veuillez ouvrir une issue ou me contacter directement.
