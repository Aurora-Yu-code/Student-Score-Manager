package com.scores.demo.services;

import com.scores.demo.common.Message;
import com.scores.demo.dto.RegisterParam;

/**
 * 基本功能Service
 * 用户（老师、学生）注册、登录、修改密码。
 *
 */
public interface UsersService {
    /**
     * 根据学号和密码登录
     * @param number
     * @param password
     * @return
     */
    Message login(String number, String password);

    /**
     * 根据手机号生成验证码
     * @param telephone
     * @return
     */
    Message generateAuthCode(String telephone);

    /**
     * 验证验证码
     * @param telephone
     * @param authCode
     * @return
     */
    Message verifyAuthCode(String telephone,String authCode);

    /**
     * 注册用户
     * @param registerParam
     * @return
     */
    Message register(RegisterParam registerParam);

    /**
     * 修改密码
     * @param number
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Message updatePassword(String number,String oldPassword,String newPassword);
}
