package com.mipo.pattern.test1;

import java.lang.reflect.Method;

/**
 * @Classname TemplatePatternDemo
 * @Description TODO
 * @Date 2021/1/7 10:31
 * @Created by li.yy
 */
public class TemplatePatternDemo {

    /**
     *  模板模式：一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行
     *  意图：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
     *  主要解决：一些方法通用，却在每一个子类都重新写了这一方法。
     *  优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现。
     *  缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
     *  使用场景： 1、有多个子类共有的方法，且逻辑相同。 2、重要的、复杂的方法，可以考虑作为模板方法。
     */
    public static void main(String[] args) throws Exception {
        Class<Cricket> cricketClass = Cricket.class;
        Method play = cricketClass.getMethod("play");
        Cricket cricket = cricketClass.newInstance();
        play.invoke(cricket);


        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
