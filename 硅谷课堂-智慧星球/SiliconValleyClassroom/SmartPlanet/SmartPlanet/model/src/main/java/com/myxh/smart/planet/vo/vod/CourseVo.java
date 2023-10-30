package com.myxh.smart.planet.vo.vod;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "课程对象")
@Data
public class CourseVo
{
    @Schema(description = "课程ID")
    private String id;
    @Schema(description = "课程标题")
    private String title;
    @Schema(description = "一级分类标题")
    private String subjectParentTitle;
    @Schema(description = "二级分类标题")
    private String subjectTitle;
    @Schema(description = "教师ID")
    private Long teacherId;
    @Schema(description = "教师姓名")
    private String teacherName;
    @Schema(description = "总课时")
    private Integer lessonNum;
    @Schema(description = "课程销售价格")
    // 只用于显示课程销售价格
    private String price;
    @Schema(description = "课程封面图片路径")
    private String cover;
    @Schema(description = "销售数量")
    private Long buyCount;
    @Schema(description = "浏览数量")
    private Long viewCount;
    @Schema(description = "课程状态")
    private String status;
    @Schema(description = "课程发布时间")
    private String publishTime;
}
