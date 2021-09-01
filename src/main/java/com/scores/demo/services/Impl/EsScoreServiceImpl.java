package com.scores.demo.services.Impl;

import com.scores.demo.Mapper.EsScoreMapper;
import com.scores.demo.domain.EsScore;
import com.scores.demo.repository.EsScoreRepository;
import com.scores.demo.services.EsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EsScoreServiceImpl implements EsScoreService {
    @Autowired
    private EsScoreRepository esScoreRepository;
    @Autowired
    private EsScoreMapper esScoreMapper;
    @Override
    public int importAll() {
        List<EsScore> esScoreList = esScoreMapper.getAllEsScoreList(null);
        Iterable<EsScore> esScoreIterable = esScoreRepository.saveAll(esScoreList);
        Iterator<EsScore> iterator = esScoreIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esScoreRepository.deleteById(id);
    }

    @Override
    public EsScore create(Long id) {
        EsScore result = null;
        List<EsScore> esScoreList = esScoreMapper.getAllEsScoreList(id);
        if (esScoreList.size() > 0) {
            EsScore esScore = esScoreList.get(0);
            result = esScoreRepository.save(esScore);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsScore> esScoreList = new ArrayList<>();
            for (Long id : ids) {
                EsScore esScore = new EsScore();
                esScore.setId(id);
                esScoreList.add(esScore);
            }
            esScoreRepository.deleteAll(esScoreList);
        }
    }

    @Override
    public Page<EsScore> search(String name, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esScoreRepository.findByNameOrNumber(name,name,pageable);
    }
}
