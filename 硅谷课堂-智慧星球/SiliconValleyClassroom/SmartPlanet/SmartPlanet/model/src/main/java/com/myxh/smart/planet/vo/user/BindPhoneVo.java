package com.myxh.smart.planet.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class BindPhoneVo
{
    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "验证码")
    private String code;
}
