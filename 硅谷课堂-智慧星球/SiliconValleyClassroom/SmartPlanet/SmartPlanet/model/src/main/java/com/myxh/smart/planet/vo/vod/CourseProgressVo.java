package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课程观看进度")
@Data
public class CourseProgressVo
{

    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "用户ID")
    private Long userId;

    @Schema(description = "总时长")
    private Float durationSum;

    @Schema(description = "观看进度总时长")
    private Float progressSum;

    @Schema(description = "观看进度")
    private Integer progress;
}
