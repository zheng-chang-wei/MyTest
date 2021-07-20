package com.example.web.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changwei.zheng
 * @date 2021/1/12 16:16
 * @describe
 */
@Table(name = "emp2")
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer deptId;

    private String name;
}
