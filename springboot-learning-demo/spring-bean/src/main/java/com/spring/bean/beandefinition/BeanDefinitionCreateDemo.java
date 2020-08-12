package com.spring.bean.beandefinition;

import com.spring.ioc.dependencies.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @program: geekbang-lessons
 * @description: BeanDefinition
 * @author: Jay
 * @create: 2020-08-11 20:43
 **/

// 通过 BeanDefinition 来定义 Bean 的元信息

public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {
        // 1. 通过 BeanDefinitionBuilder 构建
        //
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //    通过属性设置
        beanDefinitionBuilder.addPropertyValue("age", 16)
                             .addPropertyValue("name", "阿杰");
        //
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非 Bean 的最终形态，可以自定义修改

        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 的类型
        genericBeanDefinition.setBeanClass(User.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        // 通过 set MutablePropertyValues 批量操作属性
        mutablePropertyValues.add("age", 18).add("name","jay");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);


        System.out.println(beanDefinition.getPropertyValues());
        System.out.println(genericBeanDefinition);


    }
}
