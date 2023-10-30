package com.myxh.smart.planet.model.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "用户登录日志")
@TableName("user_login_log")
public class UserLoginLog extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "登录IP")
    @TableField("ip")
    private String ip;

    @Schema(description = "登录城市")
    @TableField("city")
    private String city;

    @Schema(description = "登录类型：0 -> Web，1 -> 移动")
    @TableField("type")
    private Boolean type;
}
