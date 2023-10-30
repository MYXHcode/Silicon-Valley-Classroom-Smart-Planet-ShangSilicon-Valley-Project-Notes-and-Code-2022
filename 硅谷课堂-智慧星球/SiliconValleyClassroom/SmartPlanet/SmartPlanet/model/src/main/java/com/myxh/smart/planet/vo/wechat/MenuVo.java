package com.myxh.smart.planet.vo.wechat;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "菜单")
public class MenuVo
{
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "父级ID")
    private Long parentId;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "URL")
    private String url;

    @Schema(description = "菜单Key")
    private String menuKey;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "下级")
    @TableField(exist = false)
    private List<MenuVo> children;
}
