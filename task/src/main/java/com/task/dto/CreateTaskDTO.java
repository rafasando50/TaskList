package com.task.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateTaskDTO {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

