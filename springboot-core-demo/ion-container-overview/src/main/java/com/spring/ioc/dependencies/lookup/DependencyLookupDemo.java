package com.spring.ioc.dependencies.lookup;

import com.spring.ioc.dependencies.annotation.Super;
import com.spring.ioc.dependencies.domain.User;
import com.sun.xml.internal.txw2.output.DumpSerializer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @program: geekbang-lessons
 * @description:
 * @author: Jay
 * @create: 2020-08-05 23:17
 **/

public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 启动 spring context
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-ioc.xml");

        // 1. 通过名称查找
        //        实时查找
        //  lookupInRealTime(beanFactory);
        //        延迟查找
        //  lookupInLazyTime(beanFactory);
        // 2. 通过类型查找
        //        单一类型
        //  lookupSingleByType(beanFactory);
        //        集合类型
        //  lookupCollectionByType(beanFactory);
        // 3. 通过注解查找
        //  lookupByAnnotation(beanFactory);

    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> userMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("注解查找" + userMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合类型查找" + userMap);
        }

    }

    private static void lookupSingleByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("单一类型查找：" + user);
    }

    private static void lookupInLazyTime(BeanFactory beanFactory) {
        ObjectFactory objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = (User) objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }


}
