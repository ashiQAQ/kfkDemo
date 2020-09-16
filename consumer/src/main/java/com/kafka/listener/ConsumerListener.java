package com.kafka.listener;

import com.alibaba.fastjson.JSONArray;
import com.kafka.entity.User;
import com.kafka.mapper.UserMapper;
import com.kafka.util.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
//    @Autowired
//    UserMapper userMapper;

    @KafkaListener(topics = "gyx")
    public void onMessage(String userStr){
        System.out.println(userStr);
        User user = JSONArray.parseObject(userStr, User.class);
        //持久化数据
        JDBCUtil.insert(user);
        //int r = userMapper.addUser(user);
    }
}