package com.example.quizapp.model;

public class Quiz {
    private int id;
    private String title;
    private String description;

    public Quiz(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return title;
    }
}
