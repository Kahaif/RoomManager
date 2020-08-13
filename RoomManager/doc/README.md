# RoomManager

## BDD

SQLite a été par sa légèreté et les besoins faibles de RoomManager.

**Cependant, il convient d'arranger RoomManager pour faire en sorte qu'à l'avenir une nouvelle BDD (ou autre système d'enregistrement de données) puisse être facilement ajouté**

=> Faisable avec une interface "RoomManagerRepository" qui contient des méthodes d'ajout, de suppression, etc de données depuis la base de données et de configuration et des classes concrètes (Par ex SqlLiteRoomManagerRepository)

=> pattern repository

### Schéma de base de données

![schema](schema-db.png)

## Structure JSP

les fichiers dynamiques sont dans src/main/webapp/WEB-INF/jsp

### head.jsp

Contiemt les balises html, meta et le navbar ouvrantes

doit être inclue dans chaques fichiers de contenus  (hors head.jsp)

Variables pouvant être inclues dedans : (via model.put par ex.)

- title : Titre de la page (qui s'affiche sur l'onglet du navigateur)
- brand : Titre qui se trouve à côté du navbar
- connection : Se trouve en dernier lieu du navbar et contient soit un bouton de login, soit un bouton de déconnexion
- head : est à la fin de la balise ```<head />```. 

### foot.jsp

Contient les balises html et body fermées

doit être inclue dans chaques fichiers de contenus (hors head.jsp)

### rooms.jsp

contient un calendrier affichant 

