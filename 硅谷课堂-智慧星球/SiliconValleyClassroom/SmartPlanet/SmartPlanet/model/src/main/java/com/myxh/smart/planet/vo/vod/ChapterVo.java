package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课程章节对象")
@Data
public class ChapterVo
{

    @Schema(description = "章节ID")
    private Long id;
    @Schema(description = "章节标题")
    private String title;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "章节下的课时列表")
    private List<VideoVo> children = new ArrayList<>();
}
