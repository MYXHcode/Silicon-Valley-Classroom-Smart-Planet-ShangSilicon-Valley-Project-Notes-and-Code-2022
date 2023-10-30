package com.myxh.smart.planet.model.wechat;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "菜单")
@TableName("menu")
public class Menu extends BaseEntity
{
    @Schema(description = "ID")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "网页链接，用户点击菜单可打开链接")
    private String url;

    @Schema(description = "菜单Key值，用于消息接口推送")
    @TableField("menu_key")
    private String menuKey;

    @Schema(description = "排序")
    private Integer sort;
}
