package com.myxh.smart.planet.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Getter
public enum CouponStatus
{
    NOT_USED(0, "未使用"),
    USED(1, "已使用");

    @EnumValue
    private final Integer code;
    private final String comment;

    CouponStatus(Integer code, String comment)
    {
        this.code = code;
        this.comment = comment;
    }
}
