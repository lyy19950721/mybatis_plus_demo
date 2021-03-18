package com.mipo.pattern.test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname StrategyPatternDemo
 * @Description TODO
 * @Date 2021/1/7 10:47
 * @Created by li.yy
 */
public class StrategyPatternDemo {

    /**
     * 一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
     *    在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法
     * 意图：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
     * 主要解决：在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
     * 何时使用：一个系统有许多许多类，而区分它们的只是他们直接的行为。
     * 如何解决：将这些算法封装成一个一个的类，任意地替换。
     * 关键代码：实现同一个接口。
     * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
     * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
     */
    public static void main(String[] args) {

        // 请求过来 卡号 金额
        String body = "12306";
        // 优先级 排序
        String type = "ali";
        PayEnum.getByType(type);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Strategy bean = applicationContext.getBean(PayEnum.getByType(type).getBeanName(), Strategy.class);
        Context context = new Context(bean);
        context.executeStrategy(10, 5);

        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
