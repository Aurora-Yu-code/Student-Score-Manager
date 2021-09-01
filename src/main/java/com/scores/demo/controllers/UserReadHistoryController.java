package com.scores.demo.controllers;

import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.services.UserReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户浏览记录管理Controller
 */
@RestController
@Api(tags="用户浏览记录管理相关接口")
@RequestMapping("/history")
public class UserReadHistoryController {
    @Autowired
    UserReadHistoryService userReadHistoryService;

    @ApiOperation("创建用户浏览记录接口")
    @RequestMapping("/create")
    public Message list(@RequestBody UserReadHistory userReadHistory){
        int count = userReadHistoryService.create(userReadHistory);
        if(count > 0){
            return ResultUtils.success(count);
        }else{
            return ResultUtils.error(404,"创建浏览记录失败");
        }
    }

    @ApiOperation("删除用户浏览记录接口")
    @RequestMapping("/delete")
    public Message delete(@RequestParam("ids") List<String> ids){
        int count = userReadHistoryService.delete(ids);
        if(count > 0){
            return ResultUtils.success(count);
        }else{
            return ResultUtils.error(404,"创建浏览记录失败");
        }
    }

    @ApiOperation("查询全部的用户浏览记录接口")
    @RequestMapping("/listAll")
    public Message listAll(){
        List<UserReadHistory> userReadHistoryList = userReadHistoryService.listAll();
        return ResultUtils.success(userReadHistoryList);
    }

    @ApiOperation("查询某个用户浏览记录接口")
    @RequestMapping("/list")
    public Message list(String number){
        List<UserReadHistory> userReadHistoryList = userReadHistoryService.list(number);
        return ResultUtils.success(userReadHistoryList);
    }

}
