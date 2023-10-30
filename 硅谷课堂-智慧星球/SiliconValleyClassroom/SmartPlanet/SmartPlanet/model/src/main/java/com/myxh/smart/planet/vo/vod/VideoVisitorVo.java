package com.myxh.smart.planet.vo.vod;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class VideoVisitorVo
{
    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "视频ID")
    @TableField("video_id")
    private Long videoId;

    @Schema(description = "来访者用户ID")
    @TableField("user_id")
    private String userId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "进入时间")
    @TableField("join_time")
    private String joinTime;

    @Schema(description = "用户停留的时间(单位：秒)")
    @TableField("duration")
    private Long duration;
}
