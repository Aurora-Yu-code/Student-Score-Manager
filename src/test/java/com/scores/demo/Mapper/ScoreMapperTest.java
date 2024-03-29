package com.scores.demo.Mapper;


import com.scores.demo.DemoApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScoreMapperTest extends DemoApplicationTests {

    @Autowired
    private ScoreMapper scoreMapper;

    @Test
    public void testFindScoreById(){
        List<String> scores = scoreMapper.findScoreByCourseName("math");
        System.out.println(scores.toString());
        Assert.assertEquals("88",scores.get(0));
    }
}
