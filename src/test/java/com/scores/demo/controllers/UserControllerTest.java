package com.scores.demo.controllers;

import com.scores.demo.DemoApplicationTests;
import com.scores.demo.common.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@AutoConfigureMockMvc
public class UserControllerTest extends DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        //使用上下文构建mockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * test hello interface
     *
     * @throws Exception
     */
    @Test
    public void testsHello() throws Exception {
        // 得到MvcResult自定义验证
        // 执行请求
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/hello")).andReturn();
        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();
        //断言，判断返回代码是否正确
        System.out.println(content);
        Assert.assertEquals(200, status);
        //断言，判断返回的值是否正确
        Assert.assertEquals("200", content);
    }


}

