// Task.java
package com.example.myapplication1;
public class Task {
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private String category;
    private String status;

    // Constructors
    public Task() {
        // Default constructor
    }

    public Task(String title, String description, String dueDate, String priority, String category, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    // Getters and Setters
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Custom method to get task details
    public String getDetails() {
        return "Title: " + title +
                "\nDescription: " + description +
                "\nDue Date: " + dueDate +
                "\nPriority: " + priority +
                "\nCategory: " + category +
                "\nStatus: " + status;
    }
}

