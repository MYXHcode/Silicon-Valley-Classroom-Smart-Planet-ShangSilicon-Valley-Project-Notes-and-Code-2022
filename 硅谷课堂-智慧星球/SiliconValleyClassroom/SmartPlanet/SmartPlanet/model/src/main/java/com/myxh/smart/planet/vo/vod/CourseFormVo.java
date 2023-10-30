package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课程基本信息")
@Data
public class CourseFormVo
{

    @Schema(description = "课程ID")
    private Long id;

    @Schema(description = "课程教师ID")
    private Long teacherId;

    @Schema(description = "课程专业ID")
    private Long subjectId;

    @Schema(description = "课程专业父级ID")
    private Long subjectParentId;

    @Schema(description = "课程标题")
    private String title;

    @Schema(description = "课程销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @Schema(description = "总课时")
    private Integer lessonNum;

    @Schema(description = "课程封面图片路径")
    private String cover;

    @Schema(description = "课程简介")
    private String description;
}
