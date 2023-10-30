package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课时信息")
@Data
public class VideoVo
{
    @Schema(description = "课时ID")
    private Long id;
    @Schema(description = "课时标题")
    private String title;
    @Schema(description = "是否可以试听")
    private Integer isFree;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "阿里云视频ID")
    private String videoSourceId;
}
