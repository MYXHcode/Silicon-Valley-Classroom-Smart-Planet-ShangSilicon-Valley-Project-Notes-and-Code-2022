package com.myxh.smart.planet.vo.vod;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class VideoVisitorQueryVo
{

    @Schema(description = "课程ID")
    private Long courseId;

    @Schema(description = "视频ID")
    private Long videoId;

    @Schema(description = "进入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date joinTime;
}
