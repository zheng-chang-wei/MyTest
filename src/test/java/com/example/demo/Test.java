package com.example.demo;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author changwei.zheng
 * @date 2021/1/7 19:57
 * @describe
 */
@Data
public class Test {

    public Test() {
    }

    public static void main(String[] args) {
        Integer a = new Integer(20);
        Integer b = new Integer(20);
        System.out.println(a == b);
    }

    public static void test() {
    }
}
