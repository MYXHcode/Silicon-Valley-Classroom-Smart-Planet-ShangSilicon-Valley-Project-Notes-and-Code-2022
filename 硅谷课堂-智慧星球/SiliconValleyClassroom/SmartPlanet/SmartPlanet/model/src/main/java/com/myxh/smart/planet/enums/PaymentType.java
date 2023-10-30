package com.myxh.smart.planet.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Getter
public enum PaymentType
{
    ALIPAY(1, "支付宝"),
    WECHAT(2, "微信");

    @EnumValue
    private final Integer code;
    private final String comment;

    PaymentType(Integer code, String comment)
    {
        this.code = code;
        this.comment = comment;
    }
}
