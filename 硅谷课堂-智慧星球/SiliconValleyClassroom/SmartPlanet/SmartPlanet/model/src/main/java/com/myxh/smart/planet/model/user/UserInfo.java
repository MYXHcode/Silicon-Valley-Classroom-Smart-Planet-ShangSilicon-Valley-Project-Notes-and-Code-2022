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
@Schema(description = "用户信息")
@TableName("user_info")
public class UserInfo extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    @TableField("phone")
    private String phone;

    @Schema(description = "用户密码")
    @TableField("password")
    private String password;

    @Schema(description = "用户姓名")
    @TableField("name")
    private String name;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "性别")
    @TableField("sex")
    private Integer sex;

    @Schema(description = "头像")
    @TableField("avatar")
    private String avatar;

    @Schema(description = "省")
    @TableField("province")
    private String province;

    @Schema(description = "订阅：0 -> 未订阅，1 -> 已订阅")
    @TableField("subscribe")
    private Integer subscribe;

    @Schema(description = "小程序openID")
    @TableField("open_id")
    private String openId;

    @Schema(description = "微信开放平台unionID")
    @TableField("union_id")
    private String unionId;

    @Schema(description = "推荐人用户ID")
    @TableField("recommend_id")
    private Long recommendId;

    @Schema(description = "状态")
    @TableField("status")
    private Integer status;
}
