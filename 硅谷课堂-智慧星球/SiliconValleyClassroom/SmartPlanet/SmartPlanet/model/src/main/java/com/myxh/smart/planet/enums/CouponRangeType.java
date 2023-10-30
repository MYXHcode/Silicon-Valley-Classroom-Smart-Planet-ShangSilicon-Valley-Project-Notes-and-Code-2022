package com.myxh.smart.planet.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Getter
public enum CouponRangeType
{
    ALL(1, "通用");

    @EnumValue
    private final Integer code;
    private final String comment;

    CouponRangeType(Integer code, String comment)
    {
        this.code = code;
        this.comment = comment;
    }
}
