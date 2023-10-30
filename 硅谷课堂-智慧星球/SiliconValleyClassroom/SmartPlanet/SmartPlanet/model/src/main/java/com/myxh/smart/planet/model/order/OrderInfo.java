package com.myxh.smart.planet.model.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "订单信息")
@TableName("order_info")
public class OrderInfo extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "手机")
    @TableField("phone")
    private String phone;

    @Schema(description = "原始金额")
    @TableField("origin_amount")
    private BigDecimal originAmount;

    @Schema(description = "优惠券减免")
    @TableField("coupon_reduce")
    private BigDecimal couponReduce;

    @Schema(description = "最终金额")
    @TableField("final_amount")
    private BigDecimal finalAmount;

    @Schema(description = "订单状态")
    @TableField("order_status")
    private String orderStatus;

    @Schema(description = "订单交易编号（第三方支付用)")
    @TableField("out_trade_no")
    private String outTradeNo;

    @Schema(description = "订单描述(第三方支付用)")
    @TableField("trade_body")
    private String tradeBody;

    @Schema(description = "会话ID")
    @TableField("session_id")
    private String sessionId;

    @Schema(description = "地区ID")
    @TableField("province")
    private String province;

    @Schema(description = "支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("pay_time")
    private Date payTime;

    @Schema(description = "失效时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("expire_time")
    private Date expireTime;
}
