package com.task_finalVersion.data.model;



public class Task {
    public String id;
    public String taskName;
    public String manager;
    public String status;
    public String hour;
    public String description;

    public Task(String id, String taskName, String manager, String status, String hour, String description) {
        this.id = id;
        this.taskName = taskName;
        this.manager = manager;
        this.status = status;
        this.hour = hour;
        this.description = description;
    }
}
