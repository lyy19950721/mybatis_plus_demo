package com.mipo.pattern.test4.kuozhan;

/**
 * @Classname LimitDecorator
 * @Description TODO
 * @Date 2021/1/21 15:23
 * @Created by li.yy
 */
public class LimitDecorator extends AbstractDecorator {
    public LimitDecorator() {

    }
    public LimitDecorator(GatewayComponent componentGateway) {
        super(componentGateway);
    }

    @Override
    public void service() {
        // 1.传递日志收集装饰类
        super.service();
        System.out.println("第三步>>>>API接口限流");
    }


}

