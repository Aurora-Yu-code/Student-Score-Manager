package com.scores.demo.services.Impl;


import com.scores.demo.domain.UserReadHistory;
import com.scores.demo.repository.UserReadHistoryRepository;
import com.scores.demo.services.UserReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserReadHistoryServiceImpl implements UserReadHistoryService {

    @Autowired
    private UserReadHistoryRepository userReadHistoryRepository;

    /*
    生成浏览记录
     */
    @Override
    public int create(UserReadHistory userReadHistory) {
        userReadHistory.setId(null);
        userReadHistory.setCreateTime(new Date());
        userReadHistoryRepository.save(userReadHistory);
        return 1;
    }


    /*
    批量删除浏览记录
     */
    @Override
    public int delete(List<String> ids) {
        List<UserReadHistory> deleteList = new ArrayList<>();
        for(String id:ids){
            UserReadHistory userReadHistory = new UserReadHistory();
            userReadHistory.setId(id);
            deleteList.add(userReadHistory);
        }
        userReadHistoryRepository.deleteAll(deleteList);
        return ids.size();
    }

    /*
    批量获取用户浏览历史记录
    */
    @Override
    public List<UserReadHistory> listAll() {
        return userReadHistoryRepository.findAll();
    }

    /*
    获取用户浏览历史记录
    */
    @Override
    public List<UserReadHistory> list(String number) {
        return userReadHistoryRepository.findByNumberOrderByCreateTimeDesc(number);
    }
}
