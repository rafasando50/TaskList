package com.task.dto;

import jakarta.validation.constraints.NotNull;

public class DeleteTaskDTO {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
