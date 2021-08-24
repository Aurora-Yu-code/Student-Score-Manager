package com.scores.demo.services.Impl;

import com.github.pagehelper.PageHelper;
import com.scores.demo.Mapper.ScoreMapper;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.dto.ScoreParam;
import com.scores.demo.dto.StudentScoreParam;
import com.scores.demo.mbg.mapper.StudentScoreMapper;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.mbg.model.StudentScoreExample;
import com.scores.demo.services.SysManagerService;
import com.scores.demo.services.TeacherService;
import com.scores.demo.services.UserReadHistoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private StudentScoreMapper studentScoreMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private SysManagerService sysManagerService;

    @Autowired
    private UserReadHistoryService userReadHistoryService;

    @Value("老师")
    private String TYPE;

    @Transactional
    @Override
    public Message addScore(StudentScoreParam score) {
        //查询要添加的学生学科成绩是否存在
        StudentScoreExample studentScoreExample = new StudentScoreExample();
        studentScoreExample.createCriteria().andNumberEqualTo(score.getNumber());
        List<StudentScore> studentScoreList = studentScoreMapper.selectByExample(studentScoreExample);
        //如果不存在该用户信息，则返回error
        if(studentScoreList == null || studentScoreList.size() <= 0){
            return ResultUtils.error(404,"学生不存在，添加失败");
        }
        //添加学生学科成绩
        StudentScore addStudentScore = new StudentScore();
        BeanUtils.copyProperties(score,addStudentScore);
        int result = studentScoreMapper.updateByExampleSelective(addStudentScore,studentScoreExample);
        if(result <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        //添加记录 这个地方没法获得老师的number,因此添加的是学生的number
        UserReadHistory userReadHistory = new UserReadHistory(addStudentScore.getNumber(),addStudentScore.getName(),
                TYPE,"添加学生成绩");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.success(score);
    }

    @Transactional
    @Override
    public Message addCourseScore(ScoreParam score) {
        //查询学生是否存在
        StudentScoreExample studentScoreExample = new StudentScoreExample();
        studentScoreExample.createCriteria().andNumberEqualTo(score.getNumber());
        List<StudentScore> studentScoreList = studentScoreMapper.selectByExample(studentScoreExample);
        //如果不存在该用户信息，则返回error
        if(studentScoreList == null || studentScoreList.size() <= 0){
            return ResultUtils.error(404,"学生不存在，添加失败");
        }
        //查询学科是否存在
        if(!sysManagerService.queryCourses(score.getCourseName())){
            return ResultUtils.error(404,"学科不存在，添加失败");
        }
        //更新数据
        int rs = scoreMapper.updateScoreByCourseNameandNumber(score.getNumber(),score.getCourseName(),score.getScore());
        if(rs == 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        //添加记录 这个地方没法获得老师的number,因此添加的是学生的number
        UserReadHistory userReadHistory = new UserReadHistory(score.getNumber(),score.getName(),
                TYPE,"添加学科成绩");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.success(score);
    }

    @Override
    public List<StudentScore> listAllScores() {
        return studentScoreMapper.selectByExample(new StudentScoreExample());
    }

    @Override
    public Message listAllScoresbyCourse(String courseName) {
        if(!sysManagerService.queryCourses(courseName)){
            return ResultUtils.error(404,"学科不存在");
        }
        List<Map<String,String>> scoreMapLists = new ArrayList<>();
        scoreMapLists.add(new HashMap<String,String>(){{
            put("number",courseName);
        }});
        //查所有学生的学号
        List<String> studentNumberList = scoreMapper.findNumbers();
        //查本学科的所有成绩
        List<String> studentScoreList = scoreMapper.findScoreByCourseName(courseName);
        scoreMapLists.addAll(addMapList(studentNumberList, studentScoreList));
        return ResultUtils.success(scoreMapLists);
    }

    @Override
    public List<StudentScore> listPage(int pageNum, int pageSize) {
        //利用PageHelper分页查询,pageNum表示从第几页开始，pageSize表示一页有多少内容
        PageHelper.startPage(pageNum,pageSize);
        return studentScoreMapper.selectByExample(new StudentScoreExample());
    }

    @Override
    public Message listPagebyCourse(int pageNum, int pageSize, String courseName) {
        if(!sysManagerService.queryCourses(courseName)){
            return ResultUtils.error(404,"学科不存在");
        }
        //利用自定义mapper实现分页查询,这里和全部分页的接口统一，pageNum表示第几页开始，pageSize表示一页有多少内容
        List<Map<String,String>> scoreMapLists = new ArrayList<>();
        scoreMapLists.add(new HashMap<String,String>(){{
            put("number",courseName);
        }});
        //将pageNum换算成pageStart: pageStart=(pageNum-1)*pageSize
        int pageStart = (pageNum-1)*pageSize;
        //查学生的学号
        List<String> studentNumberList = scoreMapper.findNumbersLimit(pageStart, pageSize);
        //查本学科的成绩
        List<String> studentScoreList = scoreMapper.findScoreByCourseNameLimit(pageStart, pageSize, courseName);
        scoreMapLists.addAll(addMapList(studentNumberList, studentScoreList));
        return ResultUtils.success(scoreMapLists);
    }

    /**
     * 把两个list成对转换为map再存入list中
     * @param studentNumberList
     * @param studentScoreList
     * @return
     */
    public List<Map<String,String>> addMapList(List<String> studentNumberList, List<String> studentScoreList){
        List<Map<String,String>> scoreMapLists = new ArrayList<>();
        if(studentNumberList.size() != studentScoreList.size()){
            return null;
        }
        for(int i=0;i<studentNumberList.size();i++){
            Map<String,String> map = new HashMap<>();
            map.put(studentNumberList.get(i),studentScoreList.get(i));
            scoreMapLists.add(map);
        }
        return scoreMapLists;
    }

    public List<StudentScore> queryStudent(String number){
        StudentScoreExample studentScoreExample = new StudentScoreExample();
        studentScoreExample.createCriteria().andNumberEqualTo(number);
        List<StudentScore> studentScoreList = studentScoreMapper.selectByExample(studentScoreExample);
        return studentScoreList;
    }

}
