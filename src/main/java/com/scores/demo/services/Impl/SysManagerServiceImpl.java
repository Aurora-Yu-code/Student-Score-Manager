package com.scores.demo.services.Impl;


import com.scores.demo.Mapper.CourseMapper;
import com.scores.demo.common.DBUtils;
import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.mbg.mapper.CoursesMapper;
import com.scores.demo.mbg.mapper.StudentScoreMapper;
import com.scores.demo.mbg.mapper.UserMapper;
import com.scores.demo.mbg.model.*;
import com.scores.demo.services.SysManagerService;
import com.scores.demo.services.UsersService;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.Connection;
import java.util.List;

@Service
public class SysManagerServiceImpl implements SysManagerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentScoreMapper studentScoreMapper;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private DBUtils dbutil;

    @Override
    public Message updatePassword(String number, String oldPassword, String newPassword) {
        return usersService.updatePassword(number,oldPassword,newPassword);
    }

    /*
    @Override
    public Message addCourse(String courseName) {
        //先判断是否存在该课程，当课程不存在时再进行添加
        if(queryCourses(courseName)){
            return ResultUtils.error(404,"课程已存在");
        }
        //这里利用jdbc实现
        //获取数据库连接
        Connection connection = null;
        connection = dbutil.getConnection();
        //利用preparedstatement执行sql语句
        //向学生成绩表中添加课程
        String sql = "alter table student_score add "+courseName+" varchar(255)";
        try{
            int rs = dbutil.executeSql(connection, sql);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtils.error(404,"添加失败");
        }
        //向课程表里添加课程
        Courses course = new Courses();
        course.setCoursename(courseName);
        if(coursesMapper.insert(course)<=0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        return ResultUtils.success(course);
    }
*/
    @Override
    public Message addCourse(String courseName) {
        //先判断是否存在该课程，当课程不存在时再进行添加
        if(queryCourses(courseName)){
            return ResultUtils.error(404,"课程已存在");
        }
        int rs = courseMapper.alterTableField(courseName);
        if(rs == 0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        //向课程表里添加课程
        Courses course = new Courses();
        course.setCoursename(courseName);
        if(coursesMapper.insert(course)<=0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        return ResultUtils.success(course);
    }

    @Override
    public boolean queryCourses(String courseName) {
        //查询courseName是否存在
        List<Courses> coursesList = coursesMapper.selectByExample(new CoursesExample());
        for(Courses course:coursesList){
            if(course.getCoursename().equals(courseName)){
                return true;
            }
        }
        return false;
    }
}
