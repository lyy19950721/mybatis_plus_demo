package com.mipo.pattern.web.mapper;

import com.mipo.pattern.web.entity.GatewayHandlerEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @Classname GatewayHandlerMapper
 * @Description TODO
 * @Date 2021/1/8 14:50
 * @Created by li.yy
 */
public interface GatewayHandlerMapper {

    /**
     * 获取第一个GatewayHandler
     *
     * @return
     */
    @Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid  FROM gateway_handler WHERE  prev_handler_id is null")
    GatewayHandlerEntity getFirstGatewayHandler();

    @Select("SELECT  handler_name AS handlerName,handler_id AS handlerid ,prev_handler_id AS prevhandlerid ,next_handler_id AS nexthandlerid   FROM gateway_handler WHERE  handler_id=#{handlerId}")
    GatewayHandlerEntity getByHandler(String handlerId);

}
