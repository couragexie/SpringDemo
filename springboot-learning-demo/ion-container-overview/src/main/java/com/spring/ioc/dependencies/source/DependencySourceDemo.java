package com.spring.ioc.dependencies.source;

import com.spring.ioc.dependencies.dao.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @program: geekbang-lessons
 * @description: 依赖的来源
 * @author: Jay
 * @create: 2020-08-09 23:48
 **/
// 依赖注入和依赖查找的来源并不是来自同一个地方
// 依赖的来源

public class DependencySourceDemo {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext  继承-> AbstractRefreshableApplicationContext
        // 而 AbstractRefreshableApplicationContext 中组合一个 DefaultListableBeanFactory beanFactory 的成员变量;
        // ClassPathXmlApplicationContext 中的 getBean() 操作都是调用该 DefaultListableBeanFactory 的 getBean() 方法
        // 代理模式类似
        // ClassPathXmlApplicationContext 同样也实现了 BeanFactory 的接口
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-ioc.xml");

        // 依赖来源一：获取自定义 bean 对象
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        // ClassPathXmlApplicationContext#getBeanFactory 中获取到的 BeanFactory 是 DefaultListableBeanFactory
        // 与 userRepository 中的自动注入的 BeanFactory 是同一个对象。
        System.out.println("ClassPathXmlApplicationContext#getBeanFactory" + beanFactory.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory.getBeanFactory());


        // 依赖来源二：容器内建的依赖
        // 依赖注入
        System.out.println("userRepository$BeanFactory" + userRepository.getBeanFactory());
        System.out.println(beanFactory);

        // 依赖的来源三：容器内建的 bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);
    }

}
