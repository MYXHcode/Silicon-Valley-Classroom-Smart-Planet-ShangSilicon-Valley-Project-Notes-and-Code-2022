package com.myxh.smart.planet.model.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "订单详细信息")
@TableName("order_detail")
public class OrderDetail extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "课程名称")
    @TableField("course_name")
    private String courseName;

    @Schema(description = "课程封面图片路径")
    @TableField("cover")
    private String cover;

    @Schema(description = "订单编号")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "原始金额")
    @TableField("origin_amount")
    private BigDecimal originAmount;

    @Schema(description = "优惠劵减免金额")
    @TableField("coupon_reduce")
    private BigDecimal couponReduce;

    @Schema(description = "最终金额")
    @TableField("final_amount")
    private BigDecimal finalAmount;

    @Schema(description = "会话ID：当前会话ID继承购物车中会话ID")
    @TableField("session_id")
    private String sessionId;
}
