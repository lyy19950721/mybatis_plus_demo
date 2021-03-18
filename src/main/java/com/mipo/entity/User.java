package com.mipo.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.mipo.base.BaseEntity;
import com.mipo.myenum.GenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 *
 * </p>
 *
 * @author lyy
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@FieldNameConstants
@Accessors(chain = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 使用枚举类型来限制输入值
     */
    private GenderEnum gender;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;
}
