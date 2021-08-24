package com.scores.demo.controllers;

import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.dto.UpdateParam;
import com.scores.demo.services.SysManagerService;
import com.scores.demo.common.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/System")
public class SysManagerController {

    @Autowired
    private SysManagerService sysManagerService;

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Message updatePassword(@Validated @RequestBody UpdateParam updateParam){
        return sysManagerService.updatePassword(updateParam.getNumber(),
                updateParam.getOldPassword(),updateParam.getNewPassword());
    }

    @RequestMapping("/addCourse")
    @ResponseBody
    public Message addCourse(@RequestParam("courseName") String courseName){
        //添加完课程后要重启Generator
        return sysManagerService.addCourse(courseName);
    }

}
