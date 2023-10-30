package com.myxh.smart.planet.vo.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class CouponUseQueryVo
{
    @Schema(description = "购物券ID")
    private Long couponId;

    @Schema(description = "购物券状态：1 -> 未使用，2 -> 已使用")
    private String couponStatus;

    @Schema(description = "获取时间")
    private String getTimeBegin;

    @Schema(description = "使用时间")
    private String getTimeEnd;
}
