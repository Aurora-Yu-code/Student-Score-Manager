package com.scores.demo.services;


import com.scores.demo.common.Message;

public interface StudentService {
    /**
     * 列出学生的所有成绩
     * @param number 学生学号
     * @return 成绩信息
     */
    Message listScores(String number);
}
