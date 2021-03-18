package com.mipo.pattern.web.service;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.mipo.pattern.test5.GatewayHandler;
import com.mipo.pattern.web.entity.GatewayHandlerEntity;
import com.mipo.pattern.web.mapper.GatewayHandlerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname GatewayHandlerService
 * @Description TODO
 * @Date 2021/1/8 14:51
 * @Created by li.yy
 */
@Component
public class GatewayHandlerService {

    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;
    private GatewayHandler firstGatewayHandler;

    public GatewayHandler getDbFirstGatewayHandler() {
        if (this.firstGatewayHandler != null) {
            return this.firstGatewayHandler;
        }
        // 1.查询数据库第一个handler配置
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstGatewayHandlerEntity == null) {
            return null;
        }
        String firstBeanHandlerId = firstGatewayHandlerEntity.getHandlerId();
        if (StrUtil.isEmpty(firstBeanHandlerId)) {
            return null;
        }
        // 2.从SpringBoot容器获取第一个handler对象
        GatewayHandler firstGatewayHandler = SpringUtil.getBean(firstBeanHandlerId, GatewayHandler.class);
        if (firstGatewayHandler == null) {
            return null;
        }
        // 3. 获取下一个handlerBeanId
        String nextBeanHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        // 定义临时循环遍历指针
        GatewayHandler tempNextGatewayHandler = firstGatewayHandler;
        while (StrUtil.isNotEmpty(nextBeanHandlerId)) {
            // 4.从SpringBoot容器获取下一个handler对象
            GatewayHandler nextGatewayHandler = SpringUtil.getBean(nextBeanHandlerId, GatewayHandler.class);
            if (nextGatewayHandler == null) {
                break;
            }
            // 5.从数据库查询该hanlder信息
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getByHandler(nextBeanHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            // 6.设置下一个white循环遍历hanlderid
            nextBeanHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            tempNextGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            tempNextGatewayHandler = nextGatewayHandler;
        }
        this.firstGatewayHandler = firstGatewayHandler;
        return firstGatewayHandler;

    }

}
