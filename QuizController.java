package com.example.quizapp.controller;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class QuizController {

    @FXML private ListView<String> questionListView;

    public void loadQuestions(int quizId) {
        QuestionDAO dao = new QuestionDAO();
        for (Question q : dao.getQuestionsForQuiz(quizId)) {
            questionListView.getItems().add(q.getQuestionText());
        }
    }
}
