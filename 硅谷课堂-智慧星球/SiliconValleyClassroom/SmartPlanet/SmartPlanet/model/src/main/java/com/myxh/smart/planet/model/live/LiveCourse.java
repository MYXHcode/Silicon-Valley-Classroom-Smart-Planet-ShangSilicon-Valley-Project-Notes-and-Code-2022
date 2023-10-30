package com.myxh.smart.planet.model.live;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "直播课程")
@TableName("live_course")
public class LiveCourse extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "直播名称")
    @TableField("course_name")
    private String courseName;

    @Schema(description = "直播开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("start_time")
    private Date startTime;

    @Schema(description = "直播结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("end_time")
    private Date endTime;

    @Schema(description = "主播老师id")
    @TableField("teacher_id")
    private Long teacherId;

    @Schema(description = "课程封面图片路径")
    @TableField("cover")
    private String cover;
}
