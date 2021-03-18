package com.mipo.pattern.test4.kuozhan;

/**
 * @Classname LogDecorator
 * @Description TODO
 * @Date 2021/1/21 15:22
 * @Created by li.yy
 */
public class LogDecorator extends AbstractDecorator {
    public LogDecorator() {

    }

    public LogDecorator(GatewayComponent componentGateway) {
        super(componentGateway);
    }

    @Override
    public void service() {
        // 调用装饰类service
        super.service();
        // 日志收集
        System.out.println("第二步>>>>日志的采集.....");
    }

}
