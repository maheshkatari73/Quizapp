package com.example.quizapp.dao;

import com.example.quizapp.model.Quiz;
import com.example.quizapp.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        String sql = "SELECT * FROM quizzes";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                quizzes.add(new Quiz(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description")
                ));
                System.out.println("Loaded quiz: " + rs.getString("title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }
}
