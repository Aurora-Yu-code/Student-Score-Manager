package com.scores.demo.services;

import com.scores.demo.DemoApplicationTests;
import com.scores.demo.common.Message;
import com.scores.demo.mbg.model.StudentScore;
import com.scores.demo.mbg.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceTest extends DemoApplicationTests {

    @Autowired
    private StudentService studentService;



    @Test
    public void testListScores(){

        Message message = null;
        try{
            message = studentService.listScores("1001");
        }catch (Exception e){
            e.printStackTrace();
        }
        Message expectedMes = new Message();
        expectedMes.setCode("200");
        expectedMes.setMsg("请求成功");
        expectedMes.setData(new StudentScore());
        String expectedCode = "200";
        String expectedMsg = "请求成功";
        String expectedDataName = "小红";
        StudentScore studentScore = (StudentScore) message.getData();
        System.out.println(message);
        Assert.assertEquals(expectedCode,message.getCode());
        Assert.assertEquals(expectedMsg,message.getMsg());
        Assert.assertEquals(expectedDataName,studentScore.getName());
    }

}
