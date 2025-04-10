package com.task.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dto.CreateTaskDTO;
import com.task.dto.DeleteTaskDTO;
import com.task.dto.TaskDTO;
import com.task.dto.UpdateTaskDTO;
import com.task.model.Task;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAll() {
        List<Task> tasks = taskRepository.getAll();

        List<TaskDTO> data = new LinkedList<>();

        for (Task task : tasks) {
            data.add(toDTO(task));
        }

        return data;
    }

    public TaskDTO save(CreateTaskDTO data) {
        Task model = toModel(data);
        return toDTO(taskRepository.save(model));
    }

    private Task toModel(CreateTaskDTO dto) {
        return new Task(0, dto.getTitle(), dto.getDescription(), dto.getEstado());
    }

    private Task toModel(TaskDTO dto) {
        return new Task(dto.getId(), dto.getTitle(), dto. getDescription(), dto.getEstado());
    }

    private TaskDTO toDTO(Task model) {
        return new TaskDTO(model.getId(), model.getTitle(), model.getDescription(), model.getEstado());
    }

    public TaskDTO update(UpdateTaskDTO data) {
        Task existing = taskRepository.getById(data.getId()).orElseThrow(() -> new RuntimeException("Task not found"));

        if(data.getTitle() != null) {
            existing.setTitle(data.getTitle());
        }

        if(data.getDescription() != null) {
            existing.setDescription(data.getDescription());
        }

        if(data.getEstado() != null) {
            existing.setEstado(data.getEstado());
        }

        return toDTO(taskRepository.save(existing));
    }
    
    public void delete(DeleteTaskDTO data) {
        taskRepository.delete(data);
    }
}

