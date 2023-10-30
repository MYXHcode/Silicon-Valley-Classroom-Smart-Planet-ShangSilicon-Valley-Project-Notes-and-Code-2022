package com.myxh.smart.planet.model.vod;

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
@Schema(description = "课程收藏")
@TableName("course_collect")
public class CourseCollect extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程教师ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "会员ID")
    @TableField("user_id")
    private Long userId;
}
