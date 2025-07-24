package com.example.quizapp.model;

public class Question {
    private int id;
    private int quizId;
    private String questionText, optionA, optionB, optionC, optionD, correctOption;

    public Question(int id, int quizId, String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.id = id;
        this.quizId = quizId;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public int getId() { return id; }
    public int getQuizId() { return quizId; }
    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public String getCorrectOption() { return correctOption; }
}
