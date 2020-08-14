package com.springboot.integrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateApplication.class, args);
    }

}


/*
*  SpringBoot 整合 ElasticJob 的步骤
*    1. 创建自定义的 Job 类，实现 SimpleJob 接口
*    2. 创建 zookeeper 注册中心
*    3. 创建自定义监听器， 实现 ElasticListener 接口
*    4. 创建 LiteJobConfiguration
*         a. 创建 JobCoreConfiguration
*         b. 创建 SimpleJobConfiguration
*    5. 创建 SpringJobScheduler
*    6. 项目启动的时候定时任务就会按照指定时间运行
*
* */