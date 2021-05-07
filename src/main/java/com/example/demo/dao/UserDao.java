package com.example.demo.dao;

import com.example.demo.utils.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getUserList();
}
