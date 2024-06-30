package org.taskmanagementsystem.auth;

import org.springframework.data.jpa.repository.JpaRepository;

//Schnittstelle für den Zugriff auf Datenbankoperationen, die auf der Entität "User" basieren
public interface UserRepository extends JpaRepository<User, Long> {     //Durch die Erweiterung werden CRUD-Operationen ermöglicht
    User findByUsername(String username);       //sucht Benutzer anhand des Benutzernamens aus der DB
}
