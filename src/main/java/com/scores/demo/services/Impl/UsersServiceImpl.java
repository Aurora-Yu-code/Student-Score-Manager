package com.scores.demo.services.Impl;

import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.dto.RegisterParam;
import com.scores.demo.mbg.mapper.UserMapper;
import com.scores.demo.mbg.model.User;
import com.scores.demo.mbg.model.UserExample;
import com.scores.demo.services.UserReadHistoryService;
import com.scores.demo.services.UsersService;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserReadHistoryService userReadHistoryService;


    @Override
    public Message login(String number, String password) {
        //利用Mapper提供的模糊查询接口进行查询
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNumberEqualTo(number);
        List<User> usersList = userMapper.selectByExample(userExample);
        //判断用户是否存在
        if(usersList == null || usersList.size()<=0 ){
            return ResultUtils.error(404,"用户不存在");
        }
        //判断密码是否正确
        if(!usersList.get(0).getPassword().equals(password)){
            return ResultUtils.error(404,"密码错误");
        }
        //添加记录
        UserReadHistory userReadHistory = new UserReadHistory(number,usersList.get(0).getName(),
                judgeType(usersList.get(0).getType()),"用户登录");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.loginSuccess(usersList.get(0));
    }

    @Transactional
    @Override
    public Message register(RegisterParam registerParam) {
        //先把传的参数拷贝出来
        User userAdmin = new User();  //与数据库user表对应的类
        /*copyProperties方法能够批量替换相同属性的值，将userParam中的属性替换给userAdmin,userAdmin中有的属性
        userParam中一定要有,为了调接口时主键id不必输入*/
        BeanUtils.copyProperties(registerParam, userAdmin);
        //查询是否有相同用户名的用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNumberEqualTo(userAdmin.getNumber());
        List<User> userAdminList = userMapper.selectByExample(userExample);
        if(userAdminList.size() > 0){
            return ResultUtils.error(404,"用户已经存在");
        }
        //将新注册用户加入用户表
        int result = userMapper.insert(userAdmin);
        if(result == 0){
            //注册失败回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"用户注册失败");
        }
        //添加记录
        UserReadHistory userReadHistory = new UserReadHistory(userAdmin.getNumber(),userAdmin.getName(),
                judgeType(userAdmin.getType()),"用户注册");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.success("注册成功");
    }

    @Transactional
    @Override
    public Message updatePassword(String number, String oldPassword, String newPassword) {
        //查询是否有该用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNumberEqualTo(number);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList == null || userList.size() <= 0 ){
            return ResultUtils.error(404,"用户不存在");
        }
        if(!userList.get(0).getPassword().equals(oldPassword)){
            return ResultUtils.error(404,"密码错误");
        }
        userList.get(0).setPassword(newPassword);
        int result = userMapper.updateByExampleSelective(userList.get(0),userExample);
        if(result == 0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"密码修改失败");
        }
        //添加记录
        UserReadHistory userReadHistory = new UserReadHistory(number,userList.get(0).getName(),
                judgeType(userList.get(0).getType()),"用户修改密码");
        userReadHistoryService.create(userReadHistory);
        return ResultUtils.success("修改成功");
    }

    String judgeType(int type){
        String res = null;
        switch (type){
            case 1:res = "学生";break;
            case 2:res = "老师";break;
            default:res = "管理员";
        }
        return res;
    }
}
