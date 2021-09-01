package com.scores.demo.repository;


import com.scores.demo.domain.EsScore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsScoreRepository extends ElasticsearchRepository<EsScore,Long> {
    /**
     * 搜索查询
     * @param name
     * @param number
     * @return
     */
    Page<EsScore> findByNameOrNumber(String name,String number, Pageable page);
}
