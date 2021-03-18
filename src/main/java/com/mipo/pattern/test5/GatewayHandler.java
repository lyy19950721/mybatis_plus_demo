package com.mipo.pattern.test5;

/**
 * @Classname GatewayHandler
 * @Description TODO
 * @Date 2021/1/8 10:46
 * @Created by li.yy
 */
public abstract class GatewayHandler {

    protected GatewayHandler nextGatewayHandler;

    protected abstract void service();

    public void nextService() {
        if (nextGatewayHandler != null) {
            nextGatewayHandler.service();
        }
    }

    public void setNextGatewayHandler(GatewayHandler gatewayHandler) {
        this.nextGatewayHandler = gatewayHandler;
    }
}
