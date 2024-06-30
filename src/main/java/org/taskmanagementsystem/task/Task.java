package org.taskmanagementsystem.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Felder, die die Attribute der Task-Entität darstellen
    private String title;
    private String description;
    private Date dueDate;
    private boolean completed;

    // Standardkonstruktor, der erforderlich ist, damit JPA die Entity instanziieren kann
    public Task() {}

    // Konstruktor mit Parametern, der es ermöglicht, eine Task-Instanz mit spezifischen Werten zu erstellen
    public Task(String title, String description, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false; // Standardmäßig ist die Aufgabe nicht abgeschlossen
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
