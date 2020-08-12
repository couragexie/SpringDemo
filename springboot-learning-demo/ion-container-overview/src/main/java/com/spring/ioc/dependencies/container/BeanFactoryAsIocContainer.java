package com.spring.ioc.dependencies.container;

import com.spring.ioc.dependencies.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @program: geekbang-lessons
 * @description:  使用 BeanFactory 获取对象
 * @author: Jay
 * @create: 2020-08-10 21:48
 **/

public class BeanFactoryAsIocContainer {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        // 加载 XML 配置文件
        String location = "classpath:/META-INF/dependency-lookup-ioc.xml";
        int beanDefinitionCount = xmlReader.loadBeanDefinitions(location);
        System.out.println("Bean Definition Count：" + beanDefinitionCount);

        // 依赖查找
        lookupCollectionByType(beanFactory);
    }


    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("集合类型查找" + userMap);
        }

    }


}
