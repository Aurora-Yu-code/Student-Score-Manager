package com.scores.demo.services.Impl;

import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.mbg.mapper.StudentScoreMapper;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.mbg.model.StudentScoreExample;
import com.scores.demo.services.StudentService;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.services.UserReadHistoryService;
import com.scores.demo.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentScoreMapper studentScoreMapper;

    @Autowired
    private UserReadHistoryService userReadHistoryService;

    @Value("学生")
    private String TYPE;

    @Override
    public Message listScores(String number) {
        //根据学生的number进行查询
        StudentScoreExample studentScoreExample = new StudentScoreExample();
        studentScoreExample.createCriteria().andNumberEqualTo(number);
        List<StudentScore> studentList = studentScoreMapper.selectByExample(studentScoreExample);
        if(studentList == null || studentList.size() <= 0){
            return ResultUtils.error(404,"用户不存在");
        }
        //添加记录
        UserReadHistory userReadHistory = new UserReadHistory(number,studentList.get(0).getName(),
                TYPE,"查询各科成绩");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.success(studentList.get(0));
    }
}
