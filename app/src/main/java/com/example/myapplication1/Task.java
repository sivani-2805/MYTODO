// Task.java
package com.example.myapplication1;
import java.io.Serializable;

public class Task implements Serializable {
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String category;
    private String status;

    public Task(String title, String description, String dueDate, String priority, String category, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    // Getters and Setters (you can generate these methods in your IDE)
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
}
