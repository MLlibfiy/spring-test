package com.shujia.controller;

import com.shujia.bean.StudentScore;
import com.shujia.service.StudentService;
import com.shujia.service.impl.StudentServiceImpl;
import com.shujia.util.DBUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生控制器
 */

@RestController
public class StudentController {

    private StudentService studentService = new StudentServiceImpl();


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
    public List<StudentScore> queryScore(String studentId) {


        List<StudentScore> studentScores = studentService.queryScoreById(studentId);


        return studentScores;
    }
}
