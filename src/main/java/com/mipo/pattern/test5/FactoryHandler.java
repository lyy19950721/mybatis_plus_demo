package com.mipo.pattern.test5;

/**
 * @Classname FactoryHandler
 * @Description TODO
 * @Date 2021/1/8 10:52
 * @Created by li.yy
 */
public class FactoryHandler {

    public static CurrentLimitHandler getFirstGatewayHandler() {
        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
        BlackListHandler blackListHandler = new BlackListHandler();
        currentLimitHandler.setNextGatewayHandler(blackListHandler);
        ConversationHandler conversationHandler = new ConversationHandler();
        blackListHandler.setNextGatewayHandler(conversationHandler);
        return currentLimitHandler;
    }
}
