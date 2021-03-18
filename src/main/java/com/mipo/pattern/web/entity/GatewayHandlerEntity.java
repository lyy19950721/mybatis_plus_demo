package com.mipo.pattern.web.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname GatewayHandlerEntity
 * @Description TODO
 * @Date 2021/1/8 14:50
 * @Created by li.yy
 */
@Data
public class GatewayHandlerEntity implements Serializable, Cloneable {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * handler名称
     */
    private String handlerName;
    /**
     * handler主键id
     */
    private String handlerId;
    /**
     * 下一个handler
     */
    private String nextHandlerId;

}

