package com.scores.demo.services.Impl;


import com.scores.demo.Mapper.CourseMapper;
import com.scores.demo.Mapper.coursesmapper;
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

    //自定义mapper xml文件
    @Autowired
    private coursesmapper coursesmapper;

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
 /*   @Override
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
    */

    @Override
    public Message addCourse(String courseName) {
        //先判断是否存在该课程，当课程不存在时再进行添加
        if(queryCourse(courseName)){
            return ResultUtils.error(404,"课程已存在");
        }
        //向课程表里添加课程
        int rs = coursesmapper.insertCourse(courseName);
        if(rs<=0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        int rs1 = courseMapper.alterTableField(courseName);
        if(rs1 == 0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"添加失败");
        }
        return ResultUtils.success(courseName);
    }

    @Override
    public Message deleteCourse(String courseName) {
        //先判断是否存在该课程，当课程存在时才可以删除
        if(!queryCourse(courseName)){
            return ResultUtils.error(404,"课程不存在");
        }
        int rs = coursesmapper.deleteByCourse(courseName);
        if(rs<=0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"删除失败");
        }
        int rs1 = coursesmapper.deleteTableField(courseName);
        if(rs1 == 0){
            //手动设置回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404,"删除失败");
        }
        return ResultUtils.success(courseName);
    }



    @Override
    public boolean queryCourses(String courseName) {
        //查询courseName是否存在
        List<Courses> coursesList = coursesMapper.selectByExample(new CoursesExample());
        if(coursesList == null || coursesList.size() < 1){
            return false;
        }
        return false;
    }

    public boolean queryCourse(String courseName) {
        //查询courseName是否存在
        com.scores.demo.pojo.Courses course = coursesmapper.selectByCourse(courseName);
        if(course == null){
            return false;
        }else {
            System.out.println(course.getCoursename());
            return true;
        }
    }
}
