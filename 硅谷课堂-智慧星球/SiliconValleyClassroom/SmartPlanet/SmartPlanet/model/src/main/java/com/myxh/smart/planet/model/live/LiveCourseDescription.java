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
@Schema(description = "课程简介")
@TableName("live_course_description")
public class LiveCourseDescription extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("live_course_id")
    private Long liveCourseId;

    @Schema(description = "课程简介")
    @TableField("description")
    private String description;
}
