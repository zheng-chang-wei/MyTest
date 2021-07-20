package com.example.web.service.impl;

import com.example.web.bean.User;
import com.example.web.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changwei.zheng
 * @date 2020/9/10 14:06
 * @describe
 */
@Service
public class TestServiceImpl implements TestService {

  @Autowired UserMapper userMapper;

  public List<User> listAllUsers() {
    return userMapper.selectAll();
  }

  @Transactional
  public User getUserById(int id) {
    User user1 = userMapper.selectByPrimaryKey(id);
    System.out.println(Thread.currentThread().getName() + user1);
    try {
      TimeUnit.SECONDS.sleep(6);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    User user2 = userMapper.selectByPrimaryKey(id);
    System.out.println(Thread.currentThread().getName() + user2);
    return user2;
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public User saveUser(User user) {
    AtomicInteger atomicInteger = new AtomicInteger();
    userMapper.insertSelective(user);
//    int a = 1 / 0;
    return user;
  }
  @Transactional(propagation = Propagation.SUPPORTS)
  public User saveUser() {
    User user = new User();
    user.setId(1);
    float money = 0.0001f;
    BigDecimal bigDecimal = new BigDecimal(Float.toString(money));
    while (true) {
      user.setMoney(bigDecimal.floatValue());
      userMapper.updateByPrimaryKeySelective(user);
      User user1 = userMapper.selectByPrimaryKey(user);
      if (!user1.getMoney().equals(bigDecimal.floatValue())) {
        System.err.println(user1.getMoney());
        break;
      }
      bigDecimal = bigDecimal.add(new BigDecimal(Float.toString(money)));
    }
    return user;
  }

  @Transactional
  public User updateUser(int id) {
    User user = userMapper.selectByPrimaryKey(id);
    user.setName("ls" + new Random().nextInt(10));
    userMapper.updateByPrimaryKeySelective(user);
    User user2 = userMapper.selectByPrimaryKey(id);
    System.out.println(Thread.currentThread().getName() + user2);
    return user;
  }

  @Transactional
  public int deleteUserById(int id) {
    return userMapper.deleteByPrimaryKey(id);
  }
}
