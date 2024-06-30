package org.taskmanagementsystem.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;


public class UserTests {

    @Test
    public void testUserConstructorAndGettersSetters() {
        // Testdaten
        Long id = 1L;
        String username = "testuser";
        String password = "testpassword";

        // Benutzer erstellen
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        // Getter überprüfen
        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());

        // Setter überprüfen
        Long newId = 2L;
        String newUsername = "newuser";
        String newPassword = "newpassword";

        user.setId(newId);
        user.setUsername(newUsername);
        user.setPassword(newPassword);

        assertEquals(newId, user.getId());
        assertEquals(newUsername, user.getUsername());
        assertEquals(newPassword, user.getPassword());
    }

    @Test
    public void testUserRoles() {
        // Testdaten
        String role1 = "ROLE_USER";
        String role2 = "ROLE_ADMIN";

        // Benutzer erstellen und Rollen hinzufügen
        User user = new User();
        user.setRoles(Set.of(role1, role2));

        // Rollen überprüfen
        assertTrue(user.getRoles().contains(role1));
        assertTrue(user.getRoles().contains(role2));
    }
}
