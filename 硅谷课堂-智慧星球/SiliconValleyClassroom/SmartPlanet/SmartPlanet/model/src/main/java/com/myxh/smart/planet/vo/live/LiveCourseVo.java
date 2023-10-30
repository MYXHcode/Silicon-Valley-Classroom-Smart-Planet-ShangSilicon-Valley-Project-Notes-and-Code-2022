package com.myxh.smart.planet.vo.live;

import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.vod.Teacher;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LiveCourseVo extends LiveCourse
{
    @Schema(description = "主播教师")
    private Teacher teacher;

    @Schema(description = "直播状态")
    private Integer liveStatus;

    @Schema(description = "直播开始时间")
    private String startTimeString;

    @Schema(description = "直播结束时间")
    private String endTimeString;
}
