package org.taskmanagementsystem.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindByUsername() {
        // Mock-Daten erstellen
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setPassword("password1");

        // Mock-Verhalten konfigurieren
        when(userRepository.findByUsername("user1")).thenReturn(user1);

        // Service-Methode aufrufen
        User result = userService.findByUsername("user1");

        // Ergebnisse überprüfen
        assertEquals(user1, result);
    }

    @Test
    public void testCreateUser() {
        // Mock-Daten erstellen
        User user = new User();
        user.setId(1L);
        user.setUsername("user");
        user.setPassword("password");

        // Mock-Verhalten konfigurieren
        when(userRepository.save(user)).thenReturn(user);

        // Service-Methode aufrufen
        User result = userService.createUser(user);

        // Ergebnisse überprüfen
        assertEquals(user, result);
    }

    // Weitere Testfälle für andere Methoden der UserService können hier hinzugefügt werden
}
