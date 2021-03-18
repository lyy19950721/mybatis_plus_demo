package com.mipo.java8;

/**
 * @Classname MyFun
 * @Description TODO
 * @Date 2021/3/15 15:43
 * @Created by li.yy
 */
public interface MyFun {

    default String getName(){
        return "libo";
    }

    default Integer getAge(){
        return 22;
    }

    static void getAddr(){
        System.out.println("addr");
    }

    static String Hello(){
        return "Hello World";
    }
}
