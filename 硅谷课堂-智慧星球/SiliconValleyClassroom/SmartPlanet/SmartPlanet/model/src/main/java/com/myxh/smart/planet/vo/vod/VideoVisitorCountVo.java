package com.myxh.smart.planet.vo.vod;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class VideoVisitorCountVo
{
    @Schema(description = "进入时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String joinTime;

    @Schema(description = "用户个数")
    private Integer userCount;
}
