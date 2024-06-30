package org.taskmanagementsystem.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Markeirt die Klasse als Rest Controller und implementiert REST
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    //Autowired ermöglicht einen automatisierten Zugriff auf die Eigenschaften von Task-Service
    @Autowired
    private TaskService taskService;

    //Gibt eine Liste aller Aufgaben zurück, die im System gespeichert sind
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    //Ruft einzelne Aufgaben anhand ihrer ID auf
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Nimmt Aufgaben als Request Body entgegen
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            Task createdTask = taskService.createTask(task);    //Ruft das Task Service auf und übergibt die Aufgabe
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask); //Bei Erfolg wird die Responce Entity mit dem Body, der die Aufgabe enthält, zurückgegeben
        } catch (Exception e) {     //Für den Fall dass die Aktualisierung nicht erfolgreich war
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating task: " + e.getMessage());
        }
    }

    //Nimmt auch Aufgaben als Request Body entgegen sowie die ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task updatedTask = taskService.updateTask(id, task);    //Ruft die entsprechende Methode des TaskService auf, um Aufgaben zu aktualisieren
            if (updatedTask != null) {
                return ResponseEntity.ok(updatedTask);  //Gibt die aktualisierte Aufgabe zurück
            } else {
                return ResponseEntity.notFound().build();       //Wenn die Aktualisierung nicht erfolgreich war, der Client aber die aktualisierte Aufgabe erfolgreich erhalten hat
            }
        } catch (Exception e) {     //Wenn die Aktualisierung nicht erfolgreich war, weil die Aufgabe nicht gefunden wurde
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }
    //Soll Aufgaben anhand der ID löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            boolean deleted = taskService.deleteTask(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting task: " + e.getMessage());
        }
    }
}
