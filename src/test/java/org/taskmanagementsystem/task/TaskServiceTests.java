package org.taskmanagementsystem.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testGetTaskById() {
        // Given
        Task task = new Task("Test Task", "Description for test task", new Date());
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        // When
        Task retrievedTask = taskService.getTaskById(1L);

        // Then
        verify(taskRepository, times(1)).findById(1L);
        assertEquals("Test Task", retrievedTask.getTitle());
    }

    // Add more tests for other service methods as needed
}
