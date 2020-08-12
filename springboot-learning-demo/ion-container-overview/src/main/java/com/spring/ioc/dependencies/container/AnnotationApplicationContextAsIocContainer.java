package com.spring.ioc.dependencies.container;

import com.spring.ioc.dependencies.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @program: geekbang-lessons
 * @description: 使用注解的方式，依赖注入，使用 ApplicationContext 获取对象
 * @author: Jay
 * @create: 2020-08-10 21:56
 **/

public class AnnotationApplicationContextAsIocContainer {
    public static void main(String[] args) {
        // 创建有注解能力的 ApplicationContext
        // AnnotationConfigApplicationContext 是 ApplicationContext 的实现类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationContextAsIocContainer.class);
        // 启动应用上下文
        context.refresh();
        // 运行状态
        System.out.println(context.getBean("user"));
        // 关闭应用上下文

    }

    /* IOC 容器的初始化过程 refresh() 方法
    *   1.创建 BeanFactory，并进行初步的初始化，加入一些内建的 Bean 对象或 Bean 依赖以及一些内建的非 Bean 依赖
    *   2.扩展 BeanFactory，调用 invokeBeanFactoryPostProcessors()
    *   3.对 Bean 做一些修改和扩展，调用 invokeBeanFactoryPostProcessors()
    *   4.处理国际化事件，
    *
    *  IOC 容器停止过程
    * */

    @Bean
    public User user(){
        User user  = new User();
        user.setAge(18);
        user.setName("Jay88");
        return user;
    }


}
