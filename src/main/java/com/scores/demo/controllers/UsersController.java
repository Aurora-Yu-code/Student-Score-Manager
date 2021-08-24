package com.scores.demo.controllers;


import com.scores.demo.dto.LoginParam;
import com.scores.demo.dto.RegisterParam;
import com.scores.demo.dto.UpdateParam;
import com.scores.demo.services.UsersService;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录Controller
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/hello")
    public Message hello(){ return ResultUtils.success(); }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Message login(@Validated @RequestBody LoginParam loginparam){

        return usersService.login(loginparam.getNumber(),loginparam.getPassword());
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Message register(@Validated @RequestBody RegisterParam registerParam){
        return usersService.register(registerParam);
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Message updatePassword(@Validated @RequestBody UpdateParam updateParam){
        return usersService.updatePassword(updateParam.getNumber(), updateParam.getOldPassword(),
                updateParam.getNewPassword());
    }

}
