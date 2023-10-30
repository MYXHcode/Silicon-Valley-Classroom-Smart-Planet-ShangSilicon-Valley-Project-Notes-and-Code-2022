package com.myxh.smart.planet.model.vod;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myxh.smart.planet.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "评论")
@TableName("comment")
public class Comment extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "教师ID")
    @TableField("teacher_id")
    private Long teacherId;

    @Schema(description = "会员ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "会员昵称")
    @TableField("nickname")
    private String nickname;

    @Schema(description = "会员头像")
    @TableField("avatar")
    private String avatar;

    @Schema(description = "评论内容")
    @TableField("content")
    private String content;
}
