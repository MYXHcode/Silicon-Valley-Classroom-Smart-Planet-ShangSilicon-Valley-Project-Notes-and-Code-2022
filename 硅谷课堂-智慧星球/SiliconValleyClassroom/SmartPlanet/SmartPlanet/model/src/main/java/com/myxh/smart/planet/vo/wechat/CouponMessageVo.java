package com.myxh.smart.planet.vo.wechat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "优惠券消息")
public class CouponMessageVo
{

    @Schema(description = "优惠券ID")
    private Long couponId;

    @Schema(description = "用户ID")
    private Long userId;
}
