package com.task.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.task.dto.DeleteTaskDTO;
import com.task.model.Task;

@Repository
public class TaskRepository {
    
    private long currentID;
    private List<Task> tasks;
    
    public TaskRepository() {
        currentID = 0;
        tasks = new LinkedList<>();
    }

    public List<Task> getAll() {
        return tasks;
    }


    public Optional<Task> getById(long id) {
        for (Task task : tasks) {
            if(task.getId() == id) {
                return Optional.of(task);
            }
        }
        
        return Optional.empty();
    }

    public Task save(Task data) {
        data.setID(++currentID);
        tasks.add(data);
        return data;
    }

    public void update(long id, Task data) {

        Optional<Task> entry = getById(id);

        if(!entry.isPresent()) {
            return;
        }   

        Task task = entry.get();

        if(data.getTitle() != null) {
            task.setTitle(data.getTitle());
        }

        if(data.getDescription() != null) {
            task.setDescription(data.getDescription());
        }

        if(data.getEstado() != null) {
            task.setEstado(data.getEstado());
        }
    }

    public void delete(DeleteTaskDTO data) {
        Optional<Task> taskToDelete = getById(data.getId());

        if(taskToDelete.isPresent()) {
            tasks.remove(taskToDelete.get());
        }   
    }


}
