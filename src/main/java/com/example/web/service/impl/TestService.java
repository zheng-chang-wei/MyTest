package com.example.web.service.impl;

import com.example.web.bean.User;

import java.util.List;

/**
 * @author changwei.zheng
 * @date 2021/7/14 19:14
 * @describe
 */
public interface TestService {

    List<User> listAllUsers();
    User getUserById(int id);
    User saveUser(User user);
    User updateUser(int id);
    int deleteUserById(int id);
    User saveUser();
}
