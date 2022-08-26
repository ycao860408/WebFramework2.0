package com.atguigu.factory;

import com.atguigu.pojo.User;

import java.util.Random;

public class UserFactory {
    static User getUser() {
        return new User(131, "FactoryUser", "13425", 33);
    }

    public User createUser() {
        return new User(132, "InstanceFactoryUser", "13245", 44);
    }
}
