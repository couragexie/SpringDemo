package com.spring.ioc.dependencies.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 规定该注解可以加在哪个地方
@Target({ElementType.TYPE})
// 表示该注解在运行期
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
