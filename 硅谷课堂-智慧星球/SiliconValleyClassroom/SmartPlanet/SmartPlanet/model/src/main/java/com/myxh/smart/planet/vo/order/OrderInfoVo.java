package com.myxh.smart.planet.vo.order;

import com.myxh.smart.planet.model.order.OrderInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderInfoVo extends OrderInfo
{
    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "课程名称")
    private String courseName;

    @Schema(description = "课程封面图片路径")
    private String cover;

    @Schema(description = "总时长（分钟）")
    private Integer durationSum;

    @Schema(description = "观看进度总时长（分钟）")
    private Integer progressSum;

    @Schema(description = "观看进度")
    private Integer progress;
}
