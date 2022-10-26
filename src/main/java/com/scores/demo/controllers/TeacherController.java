package com.scores.demo.controllers;

import com.scores.demo.dto.ScoreParam;
import com.scores.demo.dto.StudentScoreParam;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.services.TeacherService;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="老师功能相关接口")
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation("添加学生所有学科分数接口")
    @RequestMapping("/addScore")
    public List<Message> addScore(@Validated @RequestBody List<StudentScoreParam> studentScore){
        List<Message> mesList = new ArrayList<>();
        for(StudentScoreParam score:studentScore){
            Message mes = teacherService.addScore(score);
            mesList.add(mes);
        }
        return mesList;
    }

    @ApiOperation("添加学生某个学科分数接口")
    @RequestMapping("/addScorebyCourse")
    public List<Message> addCourseScore(@Validated @RequestBody List<ScoreParam> studentScore){
        List<Message> mesList = new ArrayList<>();
        for(ScoreParam score:studentScore){
            Message mes = teacherService.addCourseScore(score);
            mesList.add(mes);
        }
        return mesList;
    }

    @ApiOperation("查询学生所有学科分数接口")
    @RequestMapping("/listAll")
    public Message listAllScores(){
        List<StudentScore> studentScoreList = teacherService.listAllScores();
        if(studentScoreList == null && studentScoreList.size() <= 0){
            return ResultUtils.error(404,"查询失败");
        }
        return ResultUtils.success(studentScoreList);
    }

    @ApiOperation("查询学生某个学科分数接口")
    @RequestMapping("/listAllbyCourse")
    public Message listAllScoresbyCourse(@RequestParam("courseName") String courseName){
        return teacherService.listAllScoresbyCourse(courseName);
    }

    @ApiOperation("分页查询学生所有学科分数接口")
    @RequestMapping("/listPage")
    public Message listPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<StudentScore> studentScoreList = teacherService.listPage(pageNum, pageSize);
        if(studentScoreList == null && studentScoreList.size() <= 0){
            return ResultUtils.error(404,"查询失败");
        }
        return ResultUtils.success(studentScoreList);
    }

    @ApiOperation("分页查询学生某个学科分数接口")
    @RequestMapping("/listPagebyCourse")
    public Message listPagebyCourse(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam("courseName") String courseName){
        return teacherService.listPagebyCourse(pageNum, pageSize,courseName);
    }
}
