package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.CreateTaskDTO;
import com.task.dto.TaskDTO;
import com.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
    
    @Autowired
    private TaskService taskService;

    @RequestMapping("/obtenerProductos")
    public List<TaskDTO> getAll() {
        return taskService.getAll();
    }

    @RequestMapping("/crearProducto")
    public TaskDTO save(@Valid @RequestBody CreateTaskDTO data) {
        return taskService.save(data);
    }
}
