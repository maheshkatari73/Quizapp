package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import com.example.quizapp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public List<Question> getQuestionsForQuiz(int quizId) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE quiz_id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, quizId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                questions.add(new Question(
                    rs.getInt("id"),
                    rs.getInt("quiz_id"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_option")
                ));
                System.out.println("Loaded question: " + rs.getString("question_text"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
