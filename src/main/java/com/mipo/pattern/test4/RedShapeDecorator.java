package com.mipo.pattern.test4;

/**
 * @Classname RedShapeDecorator
 * @Description TODO
 * @Date 2021/1/7 14:30
 * @Created by li.yy
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
