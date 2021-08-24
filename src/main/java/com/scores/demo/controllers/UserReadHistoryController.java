package com.scores.demo.controllers;

import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.services.UserReadHistoryService;
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
@RequestMapping("/history")
public class UserReadHistoryController {
    @Autowired
    UserReadHistoryService userReadHistoryService;

    @RequestMapping("/create")
    public Message list(@RequestBody UserReadHistory userReadHistory){
        int count = userReadHistoryService.create(userReadHistory);
        if(count > 0){
            return ResultUtils.success(count);
        }else{
            return ResultUtils.error(404,"创建浏览记录失败");
        }
    }

    @RequestMapping("/delete")
    public Message delete(@RequestParam("ids") List<String> ids){
        int count = userReadHistoryService.delete(ids);
        if(count > 0){
            return ResultUtils.success(count);
        }else{
            return ResultUtils.error(404,"创建浏览记录失败");
        }
    }

    @RequestMapping("/listAll")
    public Message listAll(){
        List<UserReadHistory> userReadHistoryList = userReadHistoryService.listAll();
        return ResultUtils.success(userReadHistoryList);
    }

    @RequestMapping("/list")
    public Message list(String number){
        List<UserReadHistory> userReadHistoryList = userReadHistoryService.list(number);
        return ResultUtils.success(userReadHistoryList);
    }

}
