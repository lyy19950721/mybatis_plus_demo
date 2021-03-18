package com.mipo.pattern.test4.kuozhan;

/**
 * @Classname AbstractDecorator
 * @Description TODO
 * @Date 2021/1/21 15:22
 * @Created by li.yy
 */
public abstract class AbstractDecorator extends GatewayComponent {

    protected GatewayComponent componentGateway;

    public AbstractDecorator() {

    }

    public AbstractDecorator(GatewayComponent componentGateway) {
        this.componentGateway = componentGateway;
    }

    public void service() {
        componentGateway.service();
    }

    public void setComponentGateway(GatewayComponent componentGateway) {
        if (componentGateway != null)
            this.componentGateway = componentGateway;
    }

}
