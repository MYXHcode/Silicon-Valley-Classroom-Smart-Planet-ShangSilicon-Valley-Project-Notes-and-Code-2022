package com.myxh.smart.planet.model.live;

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
@Schema(description = "直播课程帐号")
@TableName("live_course_account")
public class LiveCourseAccount extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "直播课程id")
    @TableField("live_course_id")
    private Long liveCourseId;

    @Schema(description = "主播登录账号")
    @TableField("anchor_account")
    private String anchorAccount;

    @Schema(description = "主播登录密码")
    @TableField("anchor_password")
    private String anchorPassword;

    @Schema(description = "主播登录秘钥")
    @TableField("anchor_key")
    private String anchorKey;

    @Schema(description = "助教登录秘钥")
    @TableField("admin_key")
    private String adminKey;

    @Schema(description = "学生登录秘钥")
    @TableField("user_key")
    private String userKey;
}
