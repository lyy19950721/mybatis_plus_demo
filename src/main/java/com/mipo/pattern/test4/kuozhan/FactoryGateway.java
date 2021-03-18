package com.mipo.pattern.test4.kuozhan;

/**
 * @Classname FactoryGateway
 * @Description TODO
 * @Date 2021/1/21 15:23
 * @Created by li.yy
 */
public class FactoryGateway {

    public static GatewayComponent getGatewayComponent() {
        // 1.新增日志收集
        LogDecorator LogDecorator = new LogDecorator();
        // 2.新增Api接口限流
        LimitDecorator limitDecorator = new LimitDecorator();

        limitDecorator.setComponentGateway(LogDecorator);
        // 3.创建基本网关获取参数功能
        BasicComponentGateway basicComponentGateway = new BasicComponentGateway();

        LogDecorator.setComponentGateway(basicComponentGateway);
        return limitDecorator;
    }

    public static void main(String[] args) {
        GatewayComponent gatewayComponent = FactoryGateway.getGatewayComponent();
        gatewayComponent.service();
    }

}
