package com.shujia.controller;

import com.shujia.bean.StudentScore;
import com.shujia.util.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 学生控制器
 */

@RestController
public class StudentController {

    /**
     * value = "query"  访问路径
     * method = RequestMethod.GET  http请求方式（get  post）
     */
    //查询学生的分数  （学号，姓名，班级，科目，分数）
    @RequestMapping(value = "/query", method = RequestMethod.GET)

    /**
     * 方法的返回值如果是集合或者对象，spring回去自动将对象转成json字符串
     *
     */

    /**
     * http://localhost:8080/query?studentId=1500100001&name=张三
     * 在请求地址后面接参数  中间用?隔开
     * 参数名和方法参数名对应
     * 如果要传多个参数中间用&号
     *
     */
    public ArrayList<StudentScore> queryScore(String studentId) {
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
