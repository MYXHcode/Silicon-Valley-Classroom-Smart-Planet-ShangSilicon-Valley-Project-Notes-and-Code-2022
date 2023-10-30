package com.myxh.smart.planet.model.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.enums.PaymentStatus;
import com.myxh.smart.planet.enums.PaymentType;
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
@Schema(description = "付款信息")
@TableName("payment_info")
public class PaymentInfo extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "对外业务编号")
    @TableField("out_trade_no")
    private String outTradeNo;

    @Schema(description = "订单编号")
    @TableField("order_id")
    private Long orderId;

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "支付宝交易编号")
    @TableField("alipay_trade_no")
    private String alipayTradeNo;

    @Schema(description = "支付金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    @Schema(description = "交易内容")
    @TableField("trade_body")
    private String tradeBody;

    @Schema(description = "付款类型")
    @TableField("payment_type")
    private PaymentType paymentType;

    @Schema(description = "支付状态")
    @TableField("payment_status")
    private PaymentStatus paymentStatus;

    @Schema(description = "回调信息")
    @TableField("callback_content")
    private String callbackContent;

    @Schema(description = "回调时间")
    @TableField("callback_time")
    private Date callbackTime;
}
