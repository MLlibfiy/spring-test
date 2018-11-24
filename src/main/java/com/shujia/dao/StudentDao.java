package com.shujia.dao;

import com.shujia.bean.StudentScore;

import java.util.List;

/**
 * 学生持久层接口
 *
 */
public interface StudentDao {
    /**
     * 根据学生id查询学生各科分数
     *
     * @param studentId
     * @return
     */
    public List<StudentScore> queryScoreById(String studentId);
}
