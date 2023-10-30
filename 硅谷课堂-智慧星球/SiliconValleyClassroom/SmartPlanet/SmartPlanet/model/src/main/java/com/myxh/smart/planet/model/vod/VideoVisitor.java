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
@Schema(description = "视频来访者记录")
@TableName("video_visitor")
public class VideoVisitor extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "视频ID")
    @TableField("video_id")
    private Long videoId;

    @Schema(description = "来访者用户ID")
    @TableField("user_id")
    private Long userId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "进入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("join_time")
    private Date joinTime;

    @Schema(description = "离开的时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("leave_time")
    private Date leaveTime;

    @Schema(description = "用户停留的时间(单位：秒)")
    @TableField("duration")
    private Long duration;
}
