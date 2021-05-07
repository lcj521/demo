package com.example.demo.service;

import com.example.demo.utils.User;

import java.util.List;

public interface UserService {


    User getUserList(User user);

    List<User> queryUser();

}
