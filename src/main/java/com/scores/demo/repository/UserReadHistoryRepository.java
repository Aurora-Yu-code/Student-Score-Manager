package com.scores.demo.repository;

import com.scores.demo.domain.UserReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *  用于操作mongodb
 *  继承mongoRepository接口，同时定义了衍生查询方法
 *  用户浏览成绩信息浏览记录reposity
 */

public interface UserReadHistoryRepository extends MongoRepository<UserReadHistory,String> {
    /**
     * 自定义衍生查询：根据number按照创建时间倒序查询
     * @param number
     * @return
     */
    List<UserReadHistory> findByNumberOrderByCreateTimeDesc(String number);
}
