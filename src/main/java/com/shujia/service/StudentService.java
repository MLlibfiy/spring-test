package com.shujia.service;

import com.shujia.bean.StudentScore;

import java.util.List;

/**
 * 学生业务层接口
 *
 */
public interface StudentService {

    /**
     * 分数查询
     *
     */

    public List<StudentScore> queryScoreById(String studentId);
}
