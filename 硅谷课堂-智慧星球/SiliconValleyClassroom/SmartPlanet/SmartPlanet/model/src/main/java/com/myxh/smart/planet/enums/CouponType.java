package com.myxh.smart.planet.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Getter
public enum CouponType
{
    REGISTER(1, "注册"),
    RECOMMEND(2, "推荐购买");

    @EnumValue
    private final Integer code;
    private final String comment;

    CouponType(Integer code, String comment)
    {
        this.code = code;
        this.comment = comment;
    }
}
