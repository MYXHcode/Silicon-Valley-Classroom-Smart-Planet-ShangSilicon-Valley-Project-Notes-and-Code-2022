package com.myxh.smart.planet.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class OrderFormVo
{
    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "优惠券ID")
    private Long couponId;

    @Schema(description = "优惠券领取表ID")
    private Long couponUseId;
}
