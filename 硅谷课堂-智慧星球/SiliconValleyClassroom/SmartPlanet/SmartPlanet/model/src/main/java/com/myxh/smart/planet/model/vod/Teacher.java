package com.myxh.smart.planet.model.vod;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "教师")
@TableName("teacher")
public class Teacher extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "教师姓名")
    @TableField("name")
    private String name;

    @Schema(description = "教师简介")
    @TableField("intro")
    private String intro;

    @Schema(description = "教师资历，一句话说明教师")
    @TableField("career")
    private String career;

    @Schema(description = "头衔：1 -> 高级教师，2 -> 首席教师")
    @TableField("level")
    private Integer level;

    @Schema(description = "教师头像")
    @TableField("avatar")
    private String avatar;

    @Schema(description = "排序")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "入驻时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("join_date")
    private Date joinDate;
}
