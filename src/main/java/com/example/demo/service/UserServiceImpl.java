package com.example.demo.service;

//import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

//@Service(timeout = 2000)
@Component
@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserList(User user) {
        user.setName("张三");
        user.setAge("23");
        user.setGender("男");
        return user;
    }

    @Override
    public List<User> queryUser() {
        return userDao.getUserList();
    }


}
