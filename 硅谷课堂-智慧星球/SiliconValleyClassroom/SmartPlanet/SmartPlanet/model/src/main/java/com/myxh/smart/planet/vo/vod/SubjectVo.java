package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课程分类列表")
@Data
public class SubjectVo
{

    @Schema(description = "课程分类ID")
    private Long id;

    @Schema(description = "课程分类名称")
    private String title;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "课程二级分类列表")
    private List<SubjectVo> children = new ArrayList<>();
}
