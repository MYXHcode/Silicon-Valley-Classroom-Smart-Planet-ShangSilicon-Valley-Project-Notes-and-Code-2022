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
@Schema(description = "直播课程配置")
@TableName("live_course_config")
public class LiveCourseConfig extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "直播课程ID")
    @TableField("live_course_id")
    private Long liveCourseId;

    @Schema(description = "界面模式：1 -> 全屏模式，0 -> 二分屏，2 -> 课件模式")
    @TableField("page_view_mode")
    private Integer pageViewMode;

    @Schema(description = "是否开启观看人数：0 -> 否，1 -> 是")
    @TableField("number_enable")
    private Integer numberEnable;

    @Schema(description = "商城是否开启：0 -> 未开启，1 -> 开启")
    @TableField("store_enable")
    private Integer storeEnable;

    @Schema(description = "商店类型：1 -> 商品列表，2 -> 商城链接，3 -> 商城二维码")
    @TableField("store_type")
    private Integer storeType;
}
