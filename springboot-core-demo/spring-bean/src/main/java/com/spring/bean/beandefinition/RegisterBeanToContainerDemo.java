package com.spring.bean.beandefinition;

/**
 * @program: geekbang-lessons
 * @description: 注册 Spring bean 的方式
 * @author: Jay
 * @create: 2020-08-11 22:42
 **/

import com.spring.ioc.dependencies.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 1. xml 方式配置元信息
 * 2. Java 注解配置元信息
 *
 * @Bean
 * @Component
 * @Import 3. Java API 配置元信息
 * 命令方式：BeanDefinitionRegister#registerBeanDefinition()
 * 非命令方式：BeanDefinitionReader#registerBeanDefinition()
 * 配置类方式：AnnotatedBeanDefinitionReader#register()
 */

// 通过 @import 将 bean 添加容器中
@Import(RegisterBeanToContainerDemo.Config.class)
public class RegisterBeanToContainerDemo {

    public static void main(String[] args) {
        // 1. Java 注解配置元信息

        // AnnotationConfigApplicationContext 用于处理以注解方式添加 bean 的方式。
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册该类
        applicationContext.register(RegisterBeanToContainerDemo.class);

        // 2. Java API 的方式
        //    命名的方式
        registerUserBeanDefinition(applicationContext, "heihei");
        //    非命名的方式
        registerUserBeanDefinition(applicationContext, "");

        // 启动 applicationContext 上下文
        applicationContext.refresh();


        // 使用 @Import 和 @Componnet 注入了两个 Config.class
        // 验证 Spring 是否会重复注册两个 Config 的 bean 对象
        Map<String, Config> configs = applicationContext.getBeansOfType(Config.class);

        Map<String, User> users = applicationContext.getBeansOfType(User.class);

        System.out.println(configs);
        System.out.println(users);

        applicationContext.close();

        /***************************************/


    }

    // 通过 @Component 将 bean 添加到容器中
    @Component
    public class Config {
        // 通过 @Bean 将 bean 添加到容器中
        @Bean
        public User user() {
            User user = new User();
            user.setAge(21);
            user.setName("阿杰");
            return user;
        }

    }

    // 2. 通过 Java API 的方式来注册 bean
    public static void registerUserBeanDefinition(BeanDefinitionRegistry register, String beanName) {
        // BeanDefinitionBuilder 创建 BeanDefinition，用于定义 User 的元信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("age", "21")
                .addPropertyValue("name", "xiejie");

        // BeanDefinition 用于定义 bean 的元素性
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 如果 beanName 不为空
        if (StringUtils.hasText(beanName)) {
            // 命令方式注册 bean
            register.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命令的方式注册 bean
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), register);
        }
    }


}
