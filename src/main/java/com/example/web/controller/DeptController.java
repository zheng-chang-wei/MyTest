package com.example.web.controller;

import com.example.web.bean.Dept;
import com.example.web.bean.Test;
import com.example.web.bean.User;
import com.example.web.service.impl.DeptServiceImpl;
import com.example.web.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2020/9/10 13:54
 * @describe
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
  @Autowired DeptServiceImpl deptService;

  @GetMapping("/selectDept")
  public List<Dept> selectDept(int id) {
    return deptService.selectDept(id);
  }

  @GetMapping("/test")
  public void test(int id) throws InterruptedException {

    ArrayList<Object> list = new ArrayList<>();
    while (true) {
      list.add(new Test());
      TimeUnit.MILLISECONDS.sleep(100);
    }
  }
}
