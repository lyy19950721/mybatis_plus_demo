package com.mipo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2021/3/15 10:34
 * @Created by li.yy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
}

