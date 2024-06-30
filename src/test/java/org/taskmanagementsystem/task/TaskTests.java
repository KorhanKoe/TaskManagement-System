package org.taskmanagementsystem.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {

    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("Test Task", "Description for test task", new Date());
        task.setId(1L);
    }

    @Test
    public void testGetId() {
        assertEquals(1L, task.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Task", task.getTitle());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description for test task", task.getDescription());
    }

    @Test
    public void testGetDueDate() {
        // Erwartetes Datum festlegen
        Date expectedDueDate = new Date(); // Aktuelles Datum und Uhrzeit
        task.setDueDate(expectedDueDate);

        // Tatsächliches Datum abrufen
        Date actualDueDate = task.getDueDate();

        // Vergleichen
        assertEquals(expectedDueDate, actualDueDate);
    }


    @Test
    public void testIsCompleted() {
        assertEquals(false, task.isCompleted());
    }

    @Test
    public void testSetCompleted() {
        task.setCompleted(true);
        assertEquals(true, task.isCompleted());
    }
}
