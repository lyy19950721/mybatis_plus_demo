package com.mipo.pattern.test4;

/**
 * @Classname DecoratorPatternDemo
 * @Description TODO
 * @Date 2021/1/7 14:31
 * @Created by li.yy
 */
public class DecoratorPatternDemo {

    /**
     * 允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
     * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
     * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
     * 何时使用：在不想增加很多子类的情况下扩展类。
     * 如何解决：将具体功能职责划分，同时继承装饰者模式。
     * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
     * 缺点：多层装饰比较复杂。
     */
    public static void main(String[] args) {
        Shape circle  = new Circle();
        ShapeDecorator redCircle  = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
