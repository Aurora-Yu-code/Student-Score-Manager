package com.scores.demo.Mapper;

import com.scores.demo.domain.EsScore;

import java.util.List;

/**
 * 搜索学生信息自定义mapper
 * Created by macro on 2018/6/19.
 */
public interface EsScoreMapper {
    /**
     * 获取指定id的搜索学生成绩信息
     * @param id
     * @return
     */
    List<EsScore> getAllEsScoreList(Long id);
}
