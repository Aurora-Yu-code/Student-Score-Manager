package com.scores.demo.services;

import com.scores.demo.dto.ScoreParam;
import com.scores.demo.dto.StudentScoreParam;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.common.Message;

import java.util.List;

public interface TeacherService {
    /**
     * 添加学生的学科信息
     * @param score
     * @return
     */
    Message addScore(StudentScoreParam score);

    /**
     * 添加学生的某个学科信息
     * @param score
     * @return
     */
    Message addCourseScore(ScoreParam score);

    /**
     * 查询全部学生所有学科成绩
     * @return 学生学号与成绩
     */
    List<StudentScore> listAllScores();

    /**
     * 查询某个学科的全部学生的成绩
     * @param courseName
     * @return
     */
    Message listAllScoresbyCourse(String courseName);

    /**
     * 分页查询全部学生所有学科成绩
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<StudentScore> listPage(int pageNum, int pageSize);

    /**
     * 分页查询某个学科的学生成绩
     * @param pageNum
     * @param pageSize
     * @param courseName
     * @return
     */
    Message listPagebyCourse(int pageNum, int pageSize, String courseName);
}
