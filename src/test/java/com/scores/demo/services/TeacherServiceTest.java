package com.scores.demo.services;

import com.scores.demo.DemoApplicationTests;
import com.scores.demo.mbg.mapper.StudentScoreMapper;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.services.Impl.TeacherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceTest {


    @Mock
    private StudentScoreMapper studentScoreMapper;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Test
    public void testListAllScores(){
        List<StudentScore> studentScoreList = teacherService.listAllScores();
        for (StudentScore ss: studentScoreList) {
            System.out.println(ss);
        }
    }

    @Test
    public void testQueryStudent(){
        List<StudentScore> studentScoreList = teacherService.queryStudent("1001");
        System.out.println(studentScoreList.toString());
    }
}
