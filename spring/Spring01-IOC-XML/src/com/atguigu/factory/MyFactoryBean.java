package com.atguigu.factory;

import com.atguigu.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        System.out.println("execute factoryBean implementation~");
        return new User(112, "factoryBean", "132456", 23);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
