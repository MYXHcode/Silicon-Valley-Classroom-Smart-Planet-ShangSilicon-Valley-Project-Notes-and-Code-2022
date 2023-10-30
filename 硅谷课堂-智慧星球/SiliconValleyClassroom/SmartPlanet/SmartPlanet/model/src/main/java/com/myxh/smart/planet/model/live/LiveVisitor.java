package com.myxh.smart.planet.model.live;

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
@Schema(description = "直播来访者记录")
@TableName("live_visitor")
public class LiveVisitor extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "直播课程ID")
    @TableField("live_course_id")
    private Long liveCourseId;

    @Schema(description = "直播课程")
    @TableField("course_name")
    private String courseName;

    @Schema(description = "来访者用户ID")
    @TableField("user_id")
    private String userId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "进入时间")
    @TableField("join_time")
    private String joinTime;

    @Schema(description = "离开的时间")
    @TableField("leave_time")
    private String leaveTime;

    @Schema(description = "用户地理位置")
    @TableField("location")
    private String location;

    @Schema(description = "用户停留的时间(单位：秒)")
    @TableField("duration")
    private Long duration;

    @Schema(description = "用户停留时间(时:分:秒)")
    @TableField("duration_time")
    private String durationTime;

    @Schema(description = "平台来访者ID，去重使用")
    @TableField("live_visitor_id")
    private String liveVisitorId;
}
