package com.spring.ioc.dependencies.injection;

import com.spring.ioc.dependencies.dao.UserRepository;
import com.spring.ioc.dependencies.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: geekbang-lessons
 * @description: 依赖注入
 * @author: Jay
 * @create: 2020-08-09 18:53
 **/


public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 启动 spring context

        // ClassPathXmlApplicationContext 是 BeanFactory 的一个子类
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-ioc.xml");

        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        // 自动注入
        System.out.println(userRepository.getUsers());

        // 依赖注入
        System.out.println("userRepository$BeanFactory" + userRepository.getBeanFactory());
        System.out.println("BeanFactory" + beanFactory);
        // 会报错
        //System.out.println(beanFactory.getBean(BeanFactory.class));

        // 延迟获取对象
        // 获取到的对象是 SuperUser， 因为在定义 bean 的是，superUser 加上了 primary 属性。
//        ObjectFactory objectUserFactory = userRepository.getObjectUserFactory();
//        System.out.println(objectUserFactory.getObject());

        // 1. 通过名称查找
        // 2. 通过类型查找
        //        单一类型
        //        集合类型
        // 3. 获取内建的 bean
        // 4. 获取 bean 对象


        // ObjectFactory 的 getObject 方法获取到 ClassPathXmlApplicationContext
        // 与上面代码的 beanFactory 是同一个对象
        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());
        System.out.println(objectFactory.getObject() == beanFactory);




    }


}

