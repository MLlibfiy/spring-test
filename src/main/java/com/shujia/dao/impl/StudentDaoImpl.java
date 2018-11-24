package com.shujia.dao.impl;

import com.shujia.bean.StudentScore;
import com.shujia.dao.StudentDao;
import com.shujia.util.DBUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentScore> queryScoreById(String studentId) {
        ArrayList<StudentScore> scores = new ArrayList<>();
        Connection connection = DBUtil.getConnection();

        String sql = "select stu.id,stu.name,stu.clazz,cou.name as course,sco.score from student as  stu join score as  sco on stu.id=sco.student_id join cource as cou on sco.cource_id=cou.id where stu.id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String clazz = resultSet.getString("clazz");
                String course = resultSet.getString("course");
                int score = resultSet.getInt("score");

                StudentScore studentScore = new StudentScore(id, name, clazz, course, score);
                scores.add(studentScore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,preparedStatement);
        }
        return scores;
    }
}
