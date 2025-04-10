package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.CreateTaskDTO;
import com.task.dto.DeleteTaskDTO;
import com.task.dto.TaskDTO;
import com.task.dto.UpdateTaskDTO;
import com.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class ProductController  {
    
    @Autowired
    private TaskService taskService;

    @RequestMapping("/listarTareas")
    public List<TaskDTO> getAll() {
        return taskService.getAll();
    }

    @RequestMapping("/crearTarea")
    public TaskDTO save(@Valid @RequestBody CreateTaskDTO data) {
        return taskService.save(data);
    }

    @RequestMapping("/actualizarTarea")
    public TaskDTO update(@Valid @RequestBody UpdateTaskDTO data) {
        return taskService.update(data);
    }

    @RequestMapping("/eliminarTarea")
    public void delete(@Valid @RequestBody DeleteTaskDTO data) {
        taskService.delete(data);
    }
}
