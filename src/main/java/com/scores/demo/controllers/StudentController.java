package com.scores.demo.controllers;

import com.scores.demo.services.StudentService;
import com.scores.demo.common.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生功能模块Controller
 */

@RestController
@Api(tags="学生功能相关接口")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @ApiOperation("查询所有学科成绩接口")
    @RequestMapping("/list")
    public Message listScores(@Validated @RequestParam("number") String number){
        return studentService.listScores(number);
    }

}
