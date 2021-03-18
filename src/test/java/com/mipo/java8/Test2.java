package com.mipo.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2021/3/15 11:42
 * @Created by li.yy
 */
public class Test2 {

    /**
     * Stream API
     *  Stream 自己不会存储元素
     *  Stream 不会改变源对象 相反 他们会返回一个持有结果的新stream
     *  stream 操作是延迟执行的 这意味着他们会等到需要结果的时候才执行
     *
     *  1 创建stream
     *  2 中间操作
     *  3 终止操作
     */
    List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44),
            new Employee(105, "Jerry", 60, 4444.44)
    );

    /**
     * 创建流
     */
    @Test
    public void test01() {
        /**
         * 集合流
         *  - Collection.stream() 穿行流
         *  - Collection.parallelStream() 并行流
         */
        List<String> list1 = new ArrayList<>();
        Stream<String> stream1 = list1.stream();

        // 数组流
        String[] strings = new String[10];
        Stream<String> stream2 = Arrays.stream(strings);

        // stream of 方法
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        // 无限流 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (i) -> ++i+i++);
//        stream4.forEach(System.out::println);

        // 生成
        Stream.generate(() -> (int) (Math.random() * 100))
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test02() {
        /**
         * 筛选 / 切片
         * 中间操作
         * filter：接收 Lambda ，从流中排除某些元素
         * limit：截断流，使其元素不超过给定数量
         * skip(n)：跳过元素，返回一个舍弃了前n个元素的流；若流中元素不足n个，则返回一个空流；与 limit(n) 互补
         * distinct：筛选，通过流所生成的 hashCode() 与 equals() 取除重复元素
         */
        emps.stream()
                .filter((v) -> v.getAge()>20)
                .limit(3)
                .distinct()
                .skip(1)
                .forEach(System.out::println);
    }

    @Test
    public void test03() {
        /**
         * 映射
         * map：接收 Lambda ，将元素转换为其他形式或提取信息；
         *      接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
         * flatMap：接收一个函数作为参数，将流中每一个值都换成另一个流，然后把所有流重新连接成一个流
         */
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::print);

        list.stream()
                .flatMap(Test2::filterCharacter)
                .forEach(System.out::print);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    @Test
    public void test04() {
        /**
         * 排序
         * sorted()：自然排序
         * sorted(Comparator c)：定制排序
         */

        List<Integer> list = Arrays.asList(1,3,2,5,4);
        list.stream()
                .sorted()
                .forEach(System.out::print);
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        emps.stream()
                .sorted((a, b) -> {
                    if (a.getAge().equals(b.getAge())) {
                        return a.getName().compareTo(b.getName());
                    } else {
                        return Integer.compare(a.getAge(), b.getAge());
                    }
                })
                .forEach(System.out::println);
    }

    public enum Status {
        FREE, BUSY, VOCATION
    }

    @Test
    public void test05() {
        /**
         * 查找 / 匹配
         * allMatch：检查是否匹配所有元素
         * anyMatch：检查是否至少匹配一个元素
         * noneMatch：检查是否没有匹配所有元素
         * findFirst：返回第一个元素
         * findAny：返回当前流中的任意元素
         * count：返回流中元素的总个数
         * max：返回流中最大值
         * min：返回流中最小值
         */
        List<Status> list = Arrays.asList(Status.FREE, Status.BUSY, Status.VOCATION);
        boolean allMatch = list.stream()
                .allMatch((v) -> v.equals(Status.BUSY));
        System.out.println(allMatch);
        System.out.println("========================================================");
        boolean anyMatch = list.stream()
                .anyMatch((v) -> v.equals(Status.VOCATION));
        System.out.println(anyMatch);
        System.out.println("========================================================");
        boolean noneMatch = list.stream()
                .noneMatch((v) -> v.equals(Status.VOCATION));
        System.out.println(noneMatch);
        System.out.println("========================================================");

        Optional<Status> status = list.stream()
                .findFirst();
        System.out.println(status.orElse(Status.BUSY));
        Optional<Status> findAny = list.stream()
                .findAny();
        System.out.println(findAny.orElse(Status.BUSY));
        long count = list.stream()
                .count();
        System.out.println(count);
        Optional<Employee> employee = emps.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        System.out.println(employee.get());
        Optional<Employee> min = emps.stream()
                .min(Comparator.comparingInt(Employee::getAge));
        System.out.println(min.get());
    }

    @Test
    public void test06() {
        /**
         * 归约 / 收集
         * 归约：reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 可以将流中的数据反复结合起来，得到一个值
         * 收集：collect 将流转换成其他形式；接收一个 Collector 接口的实现，用于给流中元素做汇总的方法
         */
        /**
         * Java：
         *  - reduce：需提供默认值（初始值）
         * Kotlin：
         *  - fold：不需要默认值（初始值）
         *  - reduce：需提供默认值（初始值）
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        /**
         * 放入list
         */
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        /**
         * 放入set
         */
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        /**
         * 放入LinkedHashSet
         */
        LinkedHashSet<String> linkedHashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        linkedHashSet.forEach(System.out::println);
    }

    @Test
    public void test07() {
        // 总和
        Long collect = emps.stream()
                .collect(Collectors.counting());
        System.out.println(collect);
        // 平均值
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
        //总和
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        //最大值
        Optional<Employee> max = emps.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(max.get());
        //最小值
        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
        //总结
        IntSummaryStatistics summaryStatistics = emps.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println(summaryStatistics.getMax());
        //连接
        String join = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "(", ")"));
        System.out.println(join);
    }

    @Test
    public void test08() {
        /**
         * 分组
         */
        Map<String, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        System.out.println(collect);
        /**
         * 多级分组
         */
        Map<String, Map<String, List<Employee>>> collect1 = emps.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy((v) -> {
                    if (v.getAge() > 35) {
                        return "开除了";
                    } else {
                        return "继续加班";
                    }
                })));
        System.out.println(collect1);
        /**
         * 分区
         */
        Map<Boolean, List<Employee>> collect2 = emps.stream()
                .collect(Collectors.partitioningBy((v) -> v.getAge() > 35));
        System.out.println(collect2);
    }

}
