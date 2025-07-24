package com.example.quizapp.controller;

import com.example.quizapp.dao.QuizDAO;
import com.example.quizapp.model.Quiz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML private ListView<Quiz> quizListView;

    private QuizDAO quizDAO = new QuizDAO();

    @FXML
    public void initialize() {
        ObservableList<Quiz> quizzes = FXCollections.observableArrayList(quizDAO.getAllQuizzes());
        quizListView.setItems(quizzes);
    }

    @FXML
    private void startQuiz(ActionEvent event) throws Exception {
        Quiz selectedQuiz = quizListView.getSelectionModel().getSelectedItem();
        if (selectedQuiz == null) return;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quizapp/quiz-view.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        QuizController controller = loader.getController();
        controller.loadQuestions(selectedQuiz.getId());
        stage.show();
    }
}
