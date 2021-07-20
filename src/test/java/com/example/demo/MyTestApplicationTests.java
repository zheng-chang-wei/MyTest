package com.example.demo;

import com.example.web.bean.Dept;
import com.example.web.bean.Employee;
import com.example.web.bean.User;
import com.example.web.dao.DeptMapper;
import com.example.web.dao.EmpMapper;
import com.example.web.dao.UserMapper;
import com.example.web.service.impl.DeptServiceImpl;
import com.example.web.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTestApplicationTests {

  @Autowired DeptMapper deptMapper;

  @Autowired EmpMapper empMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  TestService testService;

  @Autowired
  DeptServiceImpl deptService;

  @Test
  public void test(){
//    Dept dept=new Dept();
//    deptService.addDept(dept);
    User user=new User();
    user.setName("aa");
    testService.saveUser(user);
  }

  @Test
  public void test_insert_user() {
    List<User> list = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      User employee = new User();
      employee.setName("用户" + i);
      employee.setDeptId(1);
      list.add(employee);
    }
    userMapper.insertList(list);
  }

  @Test
  public void test_insert_dept() {
    List<Dept> list = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      Dept dept = new Dept();
      dept.setName("总部门" + i);
      dept.setParentId(0);
      list.add(dept);
    }
    for (int i = 0; i < 10; i++) {
      Dept dept = new Dept();
      dept.setName("1子部门" + i);
      dept.setParentId(1);
      list.add(dept);
    }
    for (int i = 0; i < 10; i++) {
      Dept dept = new Dept();
      dept.setName("2子部门" + i);
      dept.setParentId(2);
      list.add(dept);
    }
    for (int i = 0; i < 10; i++) {
      Dept dept = new Dept();
      dept.setName("3子部门" + i);
      dept.setParentId(3);
      list.add(dept);
    }
    for (int i = 0; i < 10000; i++) {
      Dept dept = new Dept();
      dept.setName("子子部门" + i);
      dept.setParentId(4);
      list.add(dept);
    }
    deptMapper.insertList(list);
  }

  @Test
  public void test_insert_emp() {
    List<Employee> list = new ArrayList<>();
    for (int i = 0; i < 5000; i++) {
      Employee employee = new Employee();
      employee.setName("用户" + i);
      employee.setDeptId(1);
      list.add(employee);
    }
    for (int i = 0; i < 5000; i++) {
      Employee employee = new Employee();
      employee.setName("用户" + (i + 5000));
      employee.setDeptId(2);
      list.add(employee);
    }
  }
}
