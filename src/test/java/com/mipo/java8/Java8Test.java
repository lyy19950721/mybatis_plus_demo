package com.mipo.java8;

import org.junit.Test;

import java.util.*;

import static java.lang.System.out;

/**
 * @Classname Java8Test
 * @Description TODO
 * @Date 2021/3/15 10:26
 * @Created by li.yy
 */
public class Java8Test {

         List<Employee> emps = Arrays.asList(
                new Employee(101, "Z3", 19, 9999.99),
                new Employee(102, "L4", 20, 7777.77),
                new Employee(103, "W5", 35, 6666.66),
                new Employee(104, "Tom", 44, 1111.11),
                new Employee(105, "Jerry", 60, 4444.44)
        );


    @Test
    public void test01() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        //调用
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    @Test
    public void test02() {
        Comparator<Integer> comparator = Integer::compare;
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    @Test
    public void test03() {
        Collections.sort(emps, (x, y) -> {
            if(x.getAge().equals(y.getAge())) {
                return x.getName().compareTo(y.getName());
            } else {
                return -Integer.compare(x.getAge(), y.getAge());
            }
        });
        emps.forEach(System.out::println);
    }
}
