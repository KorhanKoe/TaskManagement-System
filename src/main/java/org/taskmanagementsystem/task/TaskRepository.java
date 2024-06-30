package org.taskmanagementsystem.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//Für den Zugriff auf die Task-Entität
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //Sucht nach Tasks mit einem speziellen Suchbegriff als Titel
    List<Task> findByTitleContaining(String keyword);

    //Fääligkeitsdatum soll zwischen zwei bestimmten Daten liegen
    List<Task> findByDueDateBetween(Date startDate, Date endDate);

    //Sucht nach abgeschlossenen Tasks
    List<Task> findByCompleted(boolean completed);

    //Löscht Tasks mit einem Fälligkeitsdatum vor einem bestimmten Datum
    void deleteByDueDateBefore(Date date);
}