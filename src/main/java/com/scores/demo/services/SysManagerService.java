package com.scores.demo.services;

import com.scores.demo.common.Message;

/**
 * 系统管理员Service
 */
public interface SysManagerService {
    /**
     * 修改用户密码
     * @param number
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Message updatePassword(String number, String oldPassword, String newPassword);

    /**
     * 添加课程
     * @param courseName
     * @return
     */
    Message addCourse(String courseName);

    /**
     * 查询现有的课程
     * @param courseName
     * @return
     */
    boolean queryCourses(String courseName);



}
