package org.taskmanagementsystem.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ElementCollection;
import java.util.Set;


//Definiert eine JPA-Entity-Klasse namens User, dient für die Benutzer-Authentifizierung
@Entity     //Annotation aus dem Jakarta.persistence API, Klasse ist JPA-Entity die in einer Datenbank gespeichert werden kann
public class User {
    @Id     //ID ist das PK-Attribut
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Generiert den PK automatisch
    private Long id;
    private String username;
    private String password;

    //Bei Benutzeraufruf werden Rollen sofort geladen
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;      //Speichert die Rollen des Benutzers, "ADMIN", "USER" etc.

    // Standardkonstruktor
    public User() {
    }

    // Getter und Setter für den Zugriff auf private Felder, User Attribute können so von außen verwendet werden
    // Anwendung von Kapselung
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
