package com.example.web.service.impl;

import com.example.web.bean.Dept;
import com.example.web.bean.User;
import com.example.web.dao.DeptMapper;
import com.example.web.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2020/9/10 14:06
 * @describe
 */
@Service
public class DeptServiceImpl {

  @PreDestroy
  public void preDestroy(){}

  @PostConstruct
  public void postConstruct(){}

  @Autowired DeptMapper deptMapper;

  @Autowired TestService testService;

  public List<Dept> selectDept(int parentId) {
    return deptMapper.selectDept(parentId);
  }

  @Transactional
  public void addDept(Dept dept){
    deptMapper.insertSelective(dept);
    User user=new User();
    testService.saveUser(user);
  }
}
