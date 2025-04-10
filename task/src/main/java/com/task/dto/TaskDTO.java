package com.task.dto;

public class TaskDTO {
    private long id;
    private String title;
    private String description;
    private String estado;

    public TaskDTO(long id, String title, String description, String estado) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

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
