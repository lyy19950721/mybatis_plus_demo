package com.mipo.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Date 2021/1/20 15:47
 * @Created by li.yy
 */
@Data
public class BaseEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
}
