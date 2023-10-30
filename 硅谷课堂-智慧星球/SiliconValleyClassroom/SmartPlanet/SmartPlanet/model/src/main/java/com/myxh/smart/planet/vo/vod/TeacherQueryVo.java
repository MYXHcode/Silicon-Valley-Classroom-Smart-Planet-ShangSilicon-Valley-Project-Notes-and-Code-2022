package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class TeacherQueryVo
{
    @Schema(description = "教师姓名")
    private String name;

    @Schema(description = "头衔：1 -> 高级教师，2 -> 首席教师")
    private Integer level;

    @Schema(description = "入驻时间")
    private String joinDateBegin;

    @Schema(description = "入驻时间")
    private String joinDateEnd;
}
