package com.myxh.smart.planet.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class OrderInfoQueryVo
{
    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "手机")
    private String phone;

    @Schema(description = "订单状态")
    private Integer orderStatus;

    @Schema(description = "订单交易编号（第三方支付用)")
    private String outTradeNo;

    @Schema(description = "地区ID")
    private String province;

    @Schema(description = "创建时间")
    private String createTimeBegin;

    @Schema(description = "创建时间")
    private String createTimeEnd;
}
