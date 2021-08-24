package com.scores.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 应用启动入口
 */

@SpringBootApplication
public class ScoreManagerApplication {

    public static void main(String[] args){
        SpringApplication.run(ScoreManagerApplication.class,args);
    }
}
