package com.myxh.smart.planet.vo.activity;

import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "优惠券信息")
public class CouponInfoVo extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Schema(description = "优惠券领取ID")
    private Long couponUseId;

    @Schema(description = "是否可用")
    private Integer available;

    @Schema(description = "优惠卷名字")
    private String name;

    @Schema(description = "卡有效开始时间（时间戳，单位毫秒）")
    private Long startAt;

    @Schema(description = "卡有效结束时间（时间戳，单位毫秒）")
    private Long endAt;

    @Schema(description = "满减条件")
    private String condition;

    @Schema(description = "描述信息，优惠券可用时展示")
    private String description;

    @Schema(description = "不可用原因，优惠券不可用时展示")
    private String reason;

    @Schema(description = "折扣券优惠金额，单位分")
    private String value;

    @Schema(description = "折扣券优惠金额文案")
    private String valueDesc;

    @Schema(description = "单位文案")
    private String unitDesc;
}
