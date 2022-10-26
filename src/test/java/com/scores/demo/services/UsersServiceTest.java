package com.scores.demo.services;

import com.scores.demo.DemoApplicationTests;
import com.scores.demo.common.Message;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UsersServiceTest  extends DemoApplicationTests{

    @Autowired
    private UsersService usersService;

    @Test
    public void testLogin() {
        String number = "1001";
        String password = "1111";
        Message message = usersService.login(number, password);
        Assert.assertEquals("200", message.getCode());
    }

}
