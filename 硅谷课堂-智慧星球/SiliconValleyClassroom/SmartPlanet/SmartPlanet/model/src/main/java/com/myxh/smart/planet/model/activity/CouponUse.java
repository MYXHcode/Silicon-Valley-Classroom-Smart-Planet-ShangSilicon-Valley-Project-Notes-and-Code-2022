package com.myxh.smart.planet.model.activity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "优惠券使用")
@TableName("coupon_use")
public class CouponUse extends BaseEntity
{

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "购物券ID")
    @TableField("coupon_id")
    private Long couponId;

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "订单ID")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "购物券状态：0 -> 未使用，1 -> 已使用")
    @TableField("coupon_status")
    private String couponStatus;

    @Schema(description = "获取时间")
    @TableField("get_time")
    private Date getTime;

    @Schema(description = "使用时间")
    @TableField("using_time")
    private Date usingTime;

    @Schema(description = "支付时间")
    @TableField("used_time")
    private Date usedTime;

    @Schema(description = "过期时间")
    @TableField("expire_time")
    private Date expireTime;
}
