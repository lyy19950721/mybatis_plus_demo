package com.mipo.myenum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @Classname GenderEnum
 * @Description TODO
 * @Date 2021/1/20 17:56
 * @Created by li.yy
 */
@Getter
public enum GenderEnum {

    MALE(1, "男"),
    FEMALE(2, "女");

    @EnumValue
    @JsonValue    //标记响应json值
    private final int code;
    private final String descp;

    GenderEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }
}
