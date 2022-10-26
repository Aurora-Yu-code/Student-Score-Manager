package com.scores.demo.controllers;


import com.scores.demo.dto.LoginParam;
import com.scores.demo.dto.RegisterParam;
import com.scores.demo.dto.UpdateParam;
import com.scores.demo.services.UsersService;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录Controller
 */
@RestController
@Api(tags="用户相关接口")
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @ApiOperation("测试接口")
    @RequestMapping(value = "/hello")
    public Message hello(){
        return ResultUtils.success();
    }

    @ApiOperation("用户登录接口")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(@Validated @RequestBody LoginParam loginparam){
        return usersService.login(loginparam.getNumber(),loginparam.getPassword());
    }
//    @ApiOperation("用户登录接口")
//    @RequestMapping(value = "/login/{number}/{password}")
//    public Message login(@PathVariable("number") String number, @PathVariable("password") String password){
////        return usersService.login(number,password);
//        return ResultUtils.success(number+password);
//    }

    @ApiOperation("用户获取验证码")
    @RequestMapping("/getAuthCode")
    public Message getAuthCode(@RequestParam String telephone){
        return usersService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping("/verifyAuthCode")
    public Message getAuthCode(@RequestParam String telephone,
                               @RequestParam String authCode){
        return usersService.verifyAuthCode(telephone,authCode);
    }

    @ApiOperation("用户注册接口")
    @RequestMapping(value = "/register")
    public Message register(@Validated @RequestBody RegisterParam registerParam){
        return usersService.register(registerParam);
    }

    @ApiOperation("用户修改密码接口")
    @RequestMapping("/updatePassword")
    public Message updatePassword(@Validated @RequestBody UpdateParam updateParam){
        return usersService.updatePassword(updateParam.getNumber(), updateParam.getOldPassword(),
                updateParam.getNewPassword());
    }

}
