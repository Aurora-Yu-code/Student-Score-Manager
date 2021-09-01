package com.scores.demo.services;

import com.scores.demo.domain.EsScore;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 学生信息搜索管理service
 */
public interface EsScoreService {
    /**
     * 从数据库中导入所有商品到ES
     * @return
     */
    int importAll();
    /**
     * 根据id删除信息
     * @param id
     */
    void delete(Long id);
    /**
     * 根据id创建信息
     * @param id
     * @return
     */
    EsScore create(Long id);
    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Long> ids);
    /**
     * 搜索服务，搜索的结果分页展示
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsScore> search(String name,Integer pageNum,Integer pageSize);



}
