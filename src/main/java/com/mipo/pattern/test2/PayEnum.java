package com.mipo.pattern.test2;

/**
 * @Classname PayEnum
 * @Description TODO
 * @Date 2021/1/7 11:05
 * @Created by li.yy
 */
public enum PayEnum {

    ALI_PAY("ali", "支付宝支付", "aliPayStrategy"),
    WECHAT_PAY("wechat", "微信支付", "wechatPayStrategy"),
    UNION_PAY("union", "银联支付", "unionPayStrategy");

    private String type;

    private String description;

    private String beanName;

    PayEnum(String type, String description, String beanName) {
        this.type = type;
        this.description = description;
        this.beanName = beanName;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getBeanName() {
        return beanName;
    }

    public static PayEnum getByType(String type) {
        if (type == null) {
            return null;
        }
        for (PayEnum payEnum : values()
        ) {
            if (payEnum.getType().equals(type)) {
                return payEnum;
            }
        }
        return null;
    }
}
