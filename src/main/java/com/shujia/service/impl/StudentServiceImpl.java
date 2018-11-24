package com.shujia.service.impl;

import com.shujia.bean.StudentScore;
import com.shujia.dao.StudentDao;
import com.shujia.dao.impl.StudentDaoImpl;
import com.shujia.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务层实现
 *
 */

/**
 * 增加注解
 * spring会自动其创建这个类的对象，放到spring的容器里面
 *
 */
@Component
public class StudentServiceImpl implements StudentService {

    //获取持久层访问对象
    //多态，父类引用指向子类对象
    @Autowired
    private StudentDao studentDao ;



    @Override
    public List<StudentScore> queryScoreById(String studentId) {
        //电泳持久层查询方法
        return studentDao.queryScoreById(studentId);
    }
}
