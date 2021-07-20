package com.example.web.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changwei.zheng
 * @date 2021/1/12 16:18
 * @describe
 */
@Table(name = "dept2")
@Data
public class Dept implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  private Integer parentId;

  private String name;
}
