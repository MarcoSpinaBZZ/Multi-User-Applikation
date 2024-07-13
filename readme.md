# Coworking Space
Das Ziel der Applikation ist es ein Backend mit einem REST-Interface zu erstellen. Die Applikation verwaltet Buchungen für ein Coworking Space. Benutzer können sich registrieren, einloggen und Buchungen erstellen oder verwalten. Administratoren haben erweiterte Rechte und können alle Buchungen einsehen und verwalten. Die Sicherheitsmechanismen basieren auf [JSON Web Token](https://jwt.io/).

## Projekt aufsetzen
Das Projekt kann von [GitHub](https://github.com/MarcoSpinaBZZ/Multi-User-Applikation) heruntergeladen werden.

## Applikationsdokumentation
Die Applikationsdokumentation finden sie im Ordner [./doc](./doc/appDoc.md).

## Die Applikation starten
Laden sie das Projekt in einen Editor ihrer Wahl und lassen sie [UserApplication.java](./src/main/java/ch/zli/m223/UserApplication.java) laufen.

## Testdaten
Der Server erzeugt beim Start auf Wunsch hin automatisch Testdaten.  
Die Testdatenerzeugung finden sie in [ServerInitialisation.java](./src/main/java/ch/zli/m223/init/ServerInitialisation.java), die Steuerung ob Testdaten erzeugt weden oder nicht in [application.properties](./src/main/resources/application.properties).

## REST-API Tests
Sie finden die passenden Postman-Scripts im './src/test/postman' Verzeichnis. 
- [Register](./src/test/postman/Register.postman_collection.json)
- [Login](./src/test/postman/Login.postman_collection.json)
- [Admin](./src/test/postman/Admin.postman_collection.json)
- [Member](./src/test/postman/Member.postman_collection.json)