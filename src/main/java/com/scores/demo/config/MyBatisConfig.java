package com.scores.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类,用于配置动态生成的mapper接口的路径,@MapperScan表示扫描的mapper类的包位置
 */
@Configuration
@MapperScan({"com.scores.demo.mbg.mapper","com.scores.demo.Mapper"})
public class MyBatisConfig {
}
