package org.springlearning.demo;

import javax.jnlp.IntegrationService;
import java.beans.*;
import java.util.stream.Stream;

/**
 * @program: geekbang-lessons
 * @description:
 * @author: Jay
 * @create: 2020-08-04 23:32
 **/

public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        // 第二个参数 stopClass，
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(beanDescriptor -> {
                    // 遍历打印 Person 的属性，getter 和 writter 方法
                    // System.out.println(beanDescriptor);

                    // 属性转换
                    // String -> Integer
                    // age -> Integer
                    //PropertyDescripter 允许添加属性编辑器 - ProperyEditor
                    Class<?> properType = beanDescriptor.getPropertyType();
                    String propertyName = beanDescriptor.getName();
                    if ("age".equals(propertyName)) {
                        // String -> Integer
                        System.out.println("转换");
                        beanDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        System.out.println(beanDescriptor.getValue("age"));
                    }
                });

    }

    // Spring 3.0 之前大量使用 PropertyEditorSupport
    // 写一个通用的转换类
    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        // 重写 setAsText
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer val = Integer.valueOf(text);
            setValue(val);
        }

    }

}
