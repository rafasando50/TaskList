package com.task.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dto.CreateTaskDTO;
import com.task.dto.TaskDTO;
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

    
}
