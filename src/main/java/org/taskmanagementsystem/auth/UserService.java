package org.taskmanagementsystem.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Diese Klasse soll wie in Spring-Anwendungen üblich die Geschäftslogik implementieren
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;      //DI für UserRepository um Datenbankoperationen für Benutzerentitäten auszuführen

    //Sucht einen Benutzer anhand des Benutzernamens
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //Erstellt einen Benutzer
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //Aktualisiert einen Benutzer
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //Lösch einen Benutzer
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
