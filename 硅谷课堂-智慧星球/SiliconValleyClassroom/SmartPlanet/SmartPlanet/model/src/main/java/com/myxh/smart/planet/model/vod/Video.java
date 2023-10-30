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
@Schema(description = "课程视频")
@TableName("video")
public class Video extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @Schema(description = "章节ID")
    @TableField("chapter_id")
    private Long chapterId;

    @Schema(description = "节点名称")
    @TableField("title")
    private String title;

    @Schema(description = "云端视频资源")
    @TableField("video_source_id")
    private String videoSourceId;

    @Schema(description = "原始文件名称")
    @TableField("video_original_name")
    private String videoOriginalName;

    @Schema(description = "排序字段")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "播放次数")
    @TableField("play_count")
    private Long playCount;

    @Schema(description = "是否可以试听：0 -> 收费，1 -> 免费")
    @TableField("is_free")
    private Integer isFree;

    @Schema(description = "视频时长（秒）")
    @TableField("duration")
    private Float duration;

    @Schema(description = "视频源文件大小（字节）")
    @TableField("size")
    private Long size;

    @Schema(description = "乐观锁")
    @TableField("version")
    private Long version;

    @Schema(description = "状态")
    @TableField("status")
    private Integer status;
}
