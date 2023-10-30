package com.myxh.smart.planet.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Getter
public enum PaymentStatus
{
    UNPAID(1, "支付中"),
    PAID(2, "已支付"),
    REFUND(-1, "已退款");

    @EnumValue
    private final Integer code;
    private final String comment;

    PaymentStatus(Integer code, String comment)
    {
        this.code = code;
        this.comment = comment;
    }
}
