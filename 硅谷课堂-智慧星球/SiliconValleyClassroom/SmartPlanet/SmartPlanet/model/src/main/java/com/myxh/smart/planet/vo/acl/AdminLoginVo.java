package com.myxh.smart.planet.vo.acl;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "管理员登录信息")
public class AdminLoginVo implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "管理员ID")
    private Long adminId;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "仓库ID")
    private Long wareId;
}
