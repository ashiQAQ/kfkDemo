package com.kafka.controller;

import com.alibaba.fastjson.JSONArray;
import com.kafka.entity.User;
import com.kafka.util.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@SpringBootApplication
//@Configuration
@RequestMapping("/kfk")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    /** kafka的生产者消费者数据监听 用生产者发送数据给消费者 */
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        //为了不自定义对象的序列化 用默认的StringSerializer,所以先转化为json再由消费者转回对象
        kafkaTemplate.send("gyx", JSONArray.toJSON(user).toString());
        return "{\"data\":\"true\"}";
    }

    /** 用mybatis获取插入的列表数据 */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> listUser(){
        //这里用jdbc读取 是为了展现给前端页面数据 实际业务中这里不用写数据库连接 数据库连接只在消费者的逻辑里写就行
        return JDBCUtil.select();
    }

}