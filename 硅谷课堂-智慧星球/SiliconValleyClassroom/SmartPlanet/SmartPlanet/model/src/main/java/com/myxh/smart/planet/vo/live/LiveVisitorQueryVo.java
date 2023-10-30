package com.myxh.smart.planet.vo.live;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class LiveVisitorQueryVo
{
    @Schema(description = "直播课程ID")
    private Long liveCourseId;
}
