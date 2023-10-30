package com.myxh.smart.planet.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "领取优惠券Vo")
public class GiveCouponVo
{
    @Schema(description = "购物券类型")
    private Integer couponType;

    @Schema(description = "优惠卷名字")
    private Long userId;
}
