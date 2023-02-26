# Projet Java JPA MariaDB Hibernate

Ce projet est une application Java qui utilise les technologies JPA (Java Persistence API), MariaDB et Hibernate pour gérer les données en base de données.

## Table of Contents
1. [Prérequis](#prérequis)
2. [Configuration de la base de données](#configuration-de-la-base-de-données)
3. [Installation](#installation)
4. [Exécution du projet](#exécution-du-projet)
5. [Remarques](#remarques)

## Prérequis
- JDK 17 ou version supérieure à 10
- Maven
- MariaDB installée localement ou accès à une instance MariaDB en ligne

## Configuration de la base de données
1. Créez une base de données vide nommée __"petstore"__.
2. Ouvrez le fichier "src/main/resources/META-INF/persistence.properties" et configurez les détails de connexion à votre base de données MariaDB.
```
Par exemple : 
    <properties>
      <property name="hibernate.archive.autodetection" value="" />
      <property name="javax.persistence.jdbc.url" value="jdbc:mariadb://127.0.0.1:votre_port/nom_bdd" />
      <property name="javax.persistence.jdbc.user" value="root" />
      <property name="javax.persistence.jdbc.password" value="votre_mdp" />
      <property name="javax.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver" />
      <property name="hbm2ddl.auto" value="update"/>
      <property name="hibernate.hbm2ddl.auto" value="update"/>
      <property name="show_sql" value="true"/>
      <property name="hibernate.show_sql" value="true"/>
      <property name="format_sql" value="true"/>
      <property name="hibernate.format_sql" value="true"/>
      <!-- Drop and create à chaque redémarrage -->
      <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
    </properties>
      
```

## Exécution du projet
1. Clonez ce dépôt sur votre ordinateur local :
    ```
    $ git clone https://github.com/Cahuete0512/tp_Java_B3_fs_grp2.git
    ```
2. Accédez à votre répertoire de projet via votre terminal :
    ```
    $ cd ../path/to/the/file/tp_java_CONTANT_Magalie/src/main/java/com.b2fsgr2.tp_java_contant_magalie/TpJavaContantMagalieApplication
    ```
3. Exécutez la commande suivante pour compiler et exécuter le projet :

   - Pour mettre à jour le pom.xml :
   ```
    $ mvn clean install
   ```
   - Pour build le projet :
   ```
    $ javac TpJavaContantMagalieApplication
   ```

## Remarques
- Après création de votre base de données MariaDB, les tables seront créées automatiquement lorsque l'application sera exécutée pour la première fois.
- Ce projet est un point de départ pour une application Java JPA MariaDB Hibernate. Il peut être personnalisé pour répondre à vos besoins.
