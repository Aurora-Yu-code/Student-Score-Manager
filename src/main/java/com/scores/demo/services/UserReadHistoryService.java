package com.scores.demo.services;

import com.scores.demo.domain.UserReadHistory;

import java.util.List;



/**
 * 浏览记录管理Service
 */
public interface UserReadHistoryService {
    /*
    生成浏览记录
     */
    int create(UserReadHistory userReadHistory);

    /*
    批量删除浏览记录
     */
    int delete(List<String> ids);

    /*
    批量列举用户浏览记录
     */
    List<UserReadHistory> listAll();

    /*
    获取用户浏览历史记录
     */
    List<UserReadHistory> list(String number);






}
