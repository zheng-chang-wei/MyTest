package com.example.web.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changwei.zheng
 * @date 2020/9/10 14:08
 * @describe
 */
@Table(name = "user")
@Data
public class User implements Serializable {
  private static final long serialVersionUID = -4852732617765810959L;

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  private String name;

  private Integer deptId;

  private Float money;
}
