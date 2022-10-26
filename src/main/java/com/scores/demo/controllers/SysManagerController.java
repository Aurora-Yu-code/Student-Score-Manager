package com.scores.demo.controllers;

import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.dto.UpdateCourseParam;
import com.scores.demo.dto.UpdateParam;
import com.scores.demo.services.SysManagerService;
import com.scores.demo.common.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="系统管理员功能相关接口")
@RequestMapping("/System")
public class SysManagerController {

    @Autowired
    private SysManagerService sysManagerService;

    @ApiOperation("修改密码接口")
    @RequestMapping("/updatePassword")
    public Message updatePassword(@Validated @RequestBody UpdateParam updateParam){
        return sysManagerService.updatePassword(updateParam.getNumber(),
                updateParam.getOldPassword(),updateParam.getNewPassword());
    }

    @ApiOperation("添加课程接口")
    @RequestMapping("/addCourse")
    public Message addCourse(@RequestParam("courseName") String courseName){
        //添加完课程后要重启Generator
        return sysManagerService.addCourse(courseName);
    }

    @ApiOperation("删除课程接口")
    @RequestMapping("/deleteCourse")
    public Message deleteCourse(@RequestParam("courseName") String courseName){
        //添加完课程后要重启Generator
        return sysManagerService.deleteCourse(courseName);
    }


}
