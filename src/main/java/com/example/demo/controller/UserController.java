package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/queryUser")
    @ResponseBody
    public User queryUser(User user){
        return   userService.getUserList(user);
        // return   userService.queryUser();
    }


    @PostMapping(value = "/queryUser")
    @ResponseBody
    public User queryUserPost(User user){
        return   userService.getUserList(user);
        // return   userService.queryUser();
    }

}
