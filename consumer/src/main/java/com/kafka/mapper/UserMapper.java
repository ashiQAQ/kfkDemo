package com.kafka.mapper;

import com.kafka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    Integer addUser(@Param("record") User user);
    List<User> listUser();
}
