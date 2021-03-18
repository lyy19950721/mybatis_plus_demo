package com.mipo.pattern.test4;

/**
 * @Classname ShapeDecorator
 * @Description TODO
 * @Date 2021/1/7 14:28
 * @Created by li.yy
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
