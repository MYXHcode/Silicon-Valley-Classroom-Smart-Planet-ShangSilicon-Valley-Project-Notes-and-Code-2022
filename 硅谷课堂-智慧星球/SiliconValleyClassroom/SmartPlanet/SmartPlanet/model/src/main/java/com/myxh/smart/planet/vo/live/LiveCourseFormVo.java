package com.myxh.smart.planet.vo.live;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class LiveCourseFormVo
{
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "直播名称")
    private String courseName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "直播开始时间")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "直播结束时间")
    private Date endTime;

    @Schema(description = "主播教师ID")
    private Long teacherId;

    @Schema(description = "主播密码")
    private String password;

    @Schema(description = "课程简介")
    private String description;

    @Schema(description = "课程封面图片路径")
    private String cover;
}
