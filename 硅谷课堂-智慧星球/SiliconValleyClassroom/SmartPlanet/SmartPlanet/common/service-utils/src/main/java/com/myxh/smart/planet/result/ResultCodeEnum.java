package com.myxh.smart.planet.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/30
 * @description 统一返回结果状态信息类
 */
@Schema(description = "统一返回结果状态信息")
@Getter
public enum ResultCodeEnum
{
    SUCCESS(20000, "成功"),
    FAIL(20001, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    PHONE_CODE_ERROR(211, "手机验证码错误"),

    MTCLOUD_ERROR(210, "直播接口异常"),

    COUPON_GET(220, "优惠券已经领取"),
    COUPON_LIMIT_GET(221, "优惠券已发放完毕"),

    FILE_UPLOAD_ERROR(21004, "文件上传错误"),
    FILE_DELETE_ERROR(21005, "文件刪除错误"),

    VOD_PALY_ERROR(209, "请购买后观看"),
    ;

    @Schema(description = "状态码")
    private final Integer code;

    @Schema(description = "返回状态信息（成功、失败）")
    private final String message;

    ResultCodeEnum(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
