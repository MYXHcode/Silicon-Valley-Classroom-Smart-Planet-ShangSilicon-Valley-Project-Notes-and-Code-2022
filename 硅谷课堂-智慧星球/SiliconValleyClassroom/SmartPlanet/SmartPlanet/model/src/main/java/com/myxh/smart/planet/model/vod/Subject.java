package com.myxh.smart.planet.model.vod;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
@Schema(description = "课程科目")
@TableName("subject")
public class Subject implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    @Schema(description = "ID")
    private Long id;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

    @Schema(description = "逻辑删除：1 -> 已删除，0 -> 未删除)")
    @JsonIgnore
    @TableLogic
    @TableField("is_deleted")
    private Integer isDeleted;

    @Schema(description = "其他参数")
    @TableField(exist = false)
    private Map<String, Object> param = new HashMap<>();

    @Schema(description = "类别名称")
    @TableField("title")
    private String title;

    @Schema(description = "父ID")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "排序字段")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "是否包含子节点")
    @TableField(exist = false)
    private boolean hasChildren;
}
