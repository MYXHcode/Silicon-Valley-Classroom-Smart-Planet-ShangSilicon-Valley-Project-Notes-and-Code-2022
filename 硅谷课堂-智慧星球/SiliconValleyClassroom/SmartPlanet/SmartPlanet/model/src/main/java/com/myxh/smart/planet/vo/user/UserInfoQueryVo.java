package com.myxh.smart.planet.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class UserInfoQueryVo
{
    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "身份证号码")
    private String idNo;

    @Schema(description = "性别")
    private String sex;

    @Schema(description = "电话号码")
    private String phone;
}
