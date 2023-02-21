package com.code4faster.dbssa.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.code4faster.dbssa.mbg.mapper"})
public class MyBatisConfig {

}