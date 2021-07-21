package com.example.string;


import org.junit.jupiter.api.Test;

/**
 * @author zcw
 * @date 2021/01/06
 * <p>
 * Description:
 **/
public class StringTest2 {
    @Test
    public void test1() {
        String a3 = new String("AA");    //在堆上创建对象AA
        a3.intern();
        String a4 = "AA"; //常量池上存在引用AA，直接返回该引用指向的堆空间对象，即a3
        System.out.println("AA" == a3);

    }

    @Test
    public void test2() {
        String aa = "AA";//设置常量AA到常量池
        String bb = "BB";//设置常量BB到常量池
        String ccdd = "CC" + "DD";//设置常量CCDD到常量池
        String neeff = new String("EE") + new String("FF");//设置EE和FF到常量池。并且添加EE、FF和EEFF对象到堆
        String aabb = aa + bb;//添加AABB对象到堆
        String gghh = "GG" + new String("HH");//设置GG和HH常量到常量池,设置HH和GGHH对象到堆
        String eeff = "EEFF";
//        String gh="GGHH";

        System.out.println(aa.intern() == aa); //true
        System.out.println(neeff.intern() == eeff.intern());//true
        System.out.println("EEFF" == neeff);//true
        String nccdd = new String("CCDD");
        System.out.println(ccdd == nccdd);//false
        System.out.println(ccdd == nccdd.intern());//true
        System.out.println(aabb.intern() == aabb);//true
        System.out.println(gghh.intern() == "GGHH");//true
    }

    @Test
    public void test3() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");
        System.out.println(str3 == str4);
        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str4.intern() == str3);
        System.out.println(str5.intern() == str4);
    }

    @Test
    public void test4() {
        //常量AA不存在，所以第一步在常量池中创建了常量AA
        String a2 = new String("AA") + new String("BB");
        String a3 = new String("AA") + new String("BB"); //创建对象AA
        String a4 = new String("AA"); //创建对象AA
        System.out.println(a3 == a3.intern()); //true 说明常量池未创建常量AABB
        System.out.println(a4 == a4.intern()); //false 说明常量池创建了AA
    }

    @Test
    public void test5() {
        String a1 = "AABB";
        String a2 = new String("AABB");
        System.out.println(a1 == a2.intern());//true
        System.out.println(a2 == a2.intern()); //false


    }

    public static void main(String[] args) {

//        String s1 = new StringBuilder().append("String").append("Test").toString();
//        System.out.println(s1.intern() == s1);
//
//        String s2 = new StringBuilder().append("ja").append("vaa").toString();
//        System.out.println(s2.intern() == s2);
//
//        String s3="String11";
//        System.out.println(s3.intern()==s3);

//        String a1 = "AA";//在常量池上创建常量AA
//        String a2 = "AA";//直接返回已经存在的常量AA
//        System.out.println(a1 == a2); //true


    }
}
