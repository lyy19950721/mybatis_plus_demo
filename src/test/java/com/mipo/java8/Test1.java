package com.mipo.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.*;
import java.util.function.*;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2021/3/15 10:44
 * @Created by li.yy
 */
public class Test1 {
    /**
     * Java内置四大核心函数式接口：
     * 函数式接口   参数类型  返回类型               用途
     * Consumer       T        无    对类型为T的对象应用操作：void accept(T t)
     * 消费型接口
     *
     * Supplier       无       T     返回类型为T的对象：T get()
     * 提供型接口
     *
     * Function<T, R> T       R      对类型为T的对象应用操作，并返回结果为R类型的对象：R apply(T t)
     * 函数型接口
     *
     * Predicate      T       boolean   确定类型为T的对象是否满足某约束，并返回boolean值：boolean test(T t)
     * 断言型接口
     */



    @Test
    public void test01(){
        Consumer<Integer> consumer = (t) -> System.out.println("消费性接口" + t);
        consumer.accept(89);
    }

    @Test
    public void test02(){
        List<Integer> list = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1,2,3);
        list.addAll(integers);
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100);
        list.add(supplier.get());
        System.out.println(supplier.get());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void test03(){
        String oldStr = "abc123456xyz";
        Function<String, String> function = (a) -> a.substring(1, a.length()-1);
        System.out.println(function.apply(oldStr));
    }

    @Test
    public void test04(){
        Integer age = 35;
        Predicate<Integer> predicate = (i) -> i>=35;
        if(predicate.test(age)) {
            System.out.println("你该退休了");
        } else {
            System.out.println("我觉得还OK啦");
        }
    }

    /**
     * 方法引用
     * 若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用”
     * 对象 :: 实例方法
     * 类 :: 静态方法
     * 类 :: 实例方法
     * **注意：**Lambda 表达实体中调用方法的参数列表、返回类型必须和函数式接口中抽象方法保持一致
     */
    @Test
    public void test05(){
        PrintStream ps = System.out;
        Consumer<String> consumer1 = (t) -> ps.println(t);
        consumer1.accept("ni hao");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("wo bu hao");
    }

    @Test
    public void test06(){
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(1, 2));
        Comparator<Integer> com2 = Integer::compareTo;
        System.out.println(com1.compare(2, 1));
    }

    @Test
    public void test07(){
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("a", "b"));
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp1.test("a", "a"));
    }

    /**
     * 构造器引用
     * ClassName :: new
     *
     * 数组引用
     * Type :: new;
     */
    @Test
    public void test08(){
        Supplier<List> sup1 = () -> new ArrayList();
        Supplier<HashMap> sup2 = HashMap::new;
        Function<Integer, String[]> function = String[]::new;
    }
}
