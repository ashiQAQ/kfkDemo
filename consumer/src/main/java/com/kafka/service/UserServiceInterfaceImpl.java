package com.kafka.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.kafka.entity.User;
import com.kafka.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceInterfaceImpl {
    @Autowired
    UserMapper userMapper;

    public Integer addUser(User user){
        return userMapper.addUser(user);
    }
    public List<User> listUser(){
        return userMapper.listUser();
    }
}
