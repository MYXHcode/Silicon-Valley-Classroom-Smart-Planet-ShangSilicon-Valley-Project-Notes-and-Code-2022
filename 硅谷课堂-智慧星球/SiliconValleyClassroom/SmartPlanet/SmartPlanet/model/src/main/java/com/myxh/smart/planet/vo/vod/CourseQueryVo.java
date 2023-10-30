package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class CourseQueryVo
{
    @Schema(description = "课程教师ID")
    private Long teacherId;

    @Schema(description = "课程专业ID")
    private Long subjectId;

    @Schema(description = "课程专业父级ID")
    private Long subjectParentId;

    @Schema(description = "课程标题")
    private String title;
}
