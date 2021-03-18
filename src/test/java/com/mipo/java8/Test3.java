package com.mipo.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Classname Test3
 * @Description TODO
 * @Date 2021/3/15 15:12
 * @Created by li.yy
 */
public class Test3 {

    /**
     * 并行流
     * 并行流：就是把一个内容分成几个数据块，并用不同的线程分别处理每个数据块的流
     * Java 8 中将并行进行了优化，我们可以很容易的对数据进行操作；
     * Stream API 可以声明性地通过 parallel() 与 sequential() 在并行流与串行流之间切换
     *
     * 底层fork join 框架 拆分任务 最后归纳收集， 采用“工作窃取”模式
     */
    /**
     * ForkJoin 框架
     */
    @Test
    public void test01(){
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000l);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

    /**
     * 普通for循环
     */
    @Test
    public void test02() {
        Instant start = Instant.now();
        long  sum = 0L;
        for (long  i = 0; i < 10000000000l; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }

    /**
     * 并行流
     */
    @Test
    public void test03() {
        Instant start = Instant.now();
        long reduce = LongStream.rangeClosed(0, 10000000000l)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
    }
}
