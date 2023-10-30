package com.myxh.smart.planet.model.vod;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "课程")
@TableName("course")
public class Course extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程教师ID")
    @TableField("teacher_id")
    private Long teacherId;

    @Schema(description = "课程专业ID")
    @TableField("subject_id")
    private Long subjectId;

    @Schema(description = "课程专业父级ID")
    @TableField("subject_parent_id")
    private Long subjectParentId;

    @Schema(description = "课程标题")
    @TableField("title")
    private String title;

    @Schema(description = "课程销售价格：0 -> 可免费观看")
    @TableField("price")
    private BigDecimal price;

    @Schema(description = "总课时")
    @TableField("lesson_num")
    private Integer lessonNum;

    @Schema(description = "视频总时长（秒）")
    @TableField("duration_sum")
    private Float durationSum;

    @Schema(description = "课程封面图片路径")
    @TableField("cover")
    private String cover;

    @Schema(description = "销售数量")
    @TableField("buy_count")
    private Long buyCount;

    @Schema(description = "浏览数量")
    @TableField("view_count")
    private Long viewCount;

    @Schema(description = "课程状态：0 -> 未发布，1 -> 已发布")
    @TableField("status")
    private Integer status;

    @Schema(description = "课程发布时间")
    @TableField("publish_time")
    private Date publishTime;
}
