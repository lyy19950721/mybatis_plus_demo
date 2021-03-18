package com.mipo.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @Classname Test4
 * @Description TODO
 * @Date 2021/3/15 15:35
 * @Created by li.yy
 */
public class Test4 {

    /**
     * Optional
     * Optional.of(T t)：创建一个 Optional 实例
     * Optional.empty(T t)：创建一个空的 Optional 实例
     * Optional.ofNullable(T t)：若 t 不为 null，创建 Optional 实例，否则空实例
     * isPresent()：判断是否包含某值
     * orElse(T t)：如果调用对象包含值，返回该值，否则返回 t
     * orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回 s 获取的值
     * map(Function f)：如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty()
     * flatmap(Function mapper)：与 map 相似，要求返回值必须是 Optional
     */
    @Test
    public void test01() {
        Optional<Employee> op1 = Optional.of(new Employee());
        Employee employee1 = op1.get();
        System.out.println(employee1);


        Optional<Employee> op3 = Optional.ofNullable(null);
        System.out.println(op3.isPresent());

        Optional<Employee> op4 = Optional.ofNullable(new Employee());
        if (op4.isPresent()) {
            Employee employee4 = op4.get();
            System.out.println(employee4);
        }
    }
}
