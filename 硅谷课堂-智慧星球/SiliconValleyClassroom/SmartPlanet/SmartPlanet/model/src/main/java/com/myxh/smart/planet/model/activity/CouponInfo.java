package com.myxh.smart.planet.model.activity;

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
@Schema(description = "优惠券信息")
@TableName("coupon_info")
public class CouponInfo extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "购物券类型：1 -> 现金券")
    @TableField("coupon_type")
    private String couponType;

    @Schema(description = "优惠卷名字")
    @TableField("coupon_name")
    private String couponName;

    @Schema(description = "金额")
    @TableField("amount")
    private BigDecimal amount;

    @Schema(description = "使用门槛：0 -> 没门槛")
    @TableField("condition_amount")
    private BigDecimal conditionAmount;

    @Schema(description = "可以领取的开始日期")
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @Schema(description = "可以领取的结束日期")
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @Schema(description = "使用范围：1 -> 全场通用")
    @TableField("range_type")
    private String rangeType;

    @Schema(description = "使用范围描述")
    @TableField("rule_desc")
    private String ruleDesc;

    @Schema(description = "发行数量")
    @TableField("publish_count")
    private Integer publishCount;

    @Schema(description = "每人限领张数")
    @TableField("per_limit")
    private Integer perLimit;

    @Schema(description = "已使用数量")
    @TableField("use_count")
    private Integer useCount;

    @Schema(description = "领取数量")
    @TableField("receive_count")
    private Integer receiveCount;

    @Schema(description = "过期时间")
    @TableField("expire_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireTime;

    @Schema(description = "发布状态：0 -> 未发布，1 -> 已发布]")
    @TableField("publish_status")
    private Boolean publishStatus;

    @Schema(description = "使用状态")
    @TableField(exist = false)
    private String couponStatus;

    @Schema(description = "优惠券领取表ID")
    @TableField(exist = false)
    private Long couponUseId;

    @Schema(description = "领取时间")
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date getTime;
}
