package com.spring.ioc.dependencies.dao;

import com.spring.ioc.dependencies.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @program: geekbang-lessons
 * @description:
 * @author: Jay
 * @create: 2020-08-09 18:56
 **/

public class UserRepository {

    private Collection<User> users;

    // 自动注入 DefaultListableBeanFactory 对象
    // 容器内建的 bean 依赖
    private BeanFactory beanFactory;

    // 延迟获取对象，注入 ObjectFactory，里面 getObject 可以获取到 SuperUser 类
    ObjectFactory<User> objectUserFactory;

    // objectFactory 获取到的对象 ClassPathXmlApplicationContext
    // 与程序启动时获取的是同一个对象
    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public ObjectFactory<User> getObjectUserFactory() {
        return objectUserFactory;
    }

    public void setObjectUserFactory(ObjectFactory<User> objectUserFactory) {
        this.objectUserFactory = objectUserFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
