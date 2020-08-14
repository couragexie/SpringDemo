package com.spring.ioc.dependencies.domain;

import com.spring.ioc.dependencies.annotation.Super;

/**
 * @program: geekbang-lessons
 * @description:
 * @author: Jay
 * @create: 2020-08-05 23:32
 **/
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
