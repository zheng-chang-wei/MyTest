package com.example.web.controller;

import com.example.web.bean.User;
import com.example.web.service.impl.TestService;
import com.example.web.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changwei.zheng
 * @date 2020/9/10 13:54
 * @describe
 */
@RestController
public class TestController {
  @Autowired
  TestService testService;

  @GetMapping("/listAllUsers")
  public List<User> listAllUsers() {
    return testService.listAllUsers();
  }

  @GetMapping("/getUserById")
  public User getUserById(int id) {
    return testService.getUserById(id);
  }

  @PostMapping("/saveUser")
  public User saveUser(User user) {
    return testService.saveUser(user);
  }

  @PostMapping("/updateUser")
  public User updateUser(int id) {
    return testService.updateUser(id);
  }

  @PostMapping("/deleteUser")
  public int deleteUser(int id) {
    return testService.deleteUserById(id);
  }

  @GetMapping("/test")
  public User insert() {
    return testService.saveUser();
  }
}
