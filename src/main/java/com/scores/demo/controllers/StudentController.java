package com.scores.demo.controllers;

import com.scores.demo.services.StudentService;
import com.scores.demo.common.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生功能模块Controller
 */

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    @ResponseBody
    public Message listScores(@Validated @RequestParam("number") String number){
        return studentService.listScores(number);
    }

}
