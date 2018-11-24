package com.shujia.service.impl;

import com.shujia.bean.StudentScore;
import com.shujia.dao.StudentDao;
import com.shujia.dao.impl.StudentDaoImpl;
import com.shujia.service.StudentService;

import java.util.List;

/**
 * 服务层实现
 *
 */
public class StudentServiceImpl implements StudentService {

    //获取持久层访问对象
    //多态，父类引用指向子类对象
    private StudentDao studentDao = new StudentDaoImpl();



    @Override
    public List<StudentScore> queryScoreById(String studentId) {
        //电泳持久层查询方法
        return studentDao.queryScoreById(studentId);
    }
}
