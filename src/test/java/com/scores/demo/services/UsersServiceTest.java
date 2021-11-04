package com.scores.demo.services;

import com.scores.demo.DemoApplicationTests;
import com.scores.demo.common.Message;
import com.scores.demo.services.Impl.UsersServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


public class UsersServiceTest  {

//    @TestConfiguration
//    static class prepareCustomServices{
//        @Bean
//        public UsersService getCustomUrlServiceImpl() {
//            return new UsersServiceImpl();
//        }
//    }

    @Autowired
    private UsersService usersService;

    @Test
    public void testLogin() {
//        UsersService usersService = new UsersServiceImpl();
        String number = "1001";
        String password = "1111";
        Message message = usersService.login(number, password);
        Assert.assertEquals("200", message.getCode());
    }

}
