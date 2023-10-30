package com.myxh.smart.planet.vo.live;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class LiveCourseQueryVo
{
    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "直播名称")
    private String courseName;

    @Schema(description = "直播开始时间")
    private Date startTime;

    @Schema(description = "直播结束时间")
    private Date endTime;

    @Schema(description = "接入方主播账号或ID或手机号等，最长32位")
    private String account;

    @Schema(description = "主播表ID")
    private Long liveAnchorId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Schema(description = "逻辑删除标志")
    private Integer isDeleted;
}
