package com.myxh.smart.planet.vod.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Tag(name = "课程 API", description = "课程 API 接口")
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据关键字查询课程
     *
     * @param keyword 关键字
     * @return courseList 课程信息
     */
    @Operation(summary = "根据关键字查询课程", description = "根据关键字查询课程")
    @GetMapping("inner/find/by/keyword/{keyword}")
    public List<Course> findByKeyword(
            @Parameter(name = "keyword", description = "关键字", required = true)
            @PathVariable("keyword") String keyword)
    {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword);
        List<Course> courseList = courseService.list(queryWrapper);

        return courseList;
    }

    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param subjectParentId 课程一级分类 id
     * @param current         当前页码
     * @param limit           每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程分类查询课程列表（分页）", description = "根据课程分类查询课程列表（分页）")
    @GetMapping("{subjectParentId}/{current}/{limit}")
    public Result<Map<String, Object>> findCoursePage(@Parameter(name = "subjectParentId", description = "课程一级分类 ID", required = true) @PathVariable Long subjectParentId,
                                                      @Parameter(name = "current", description = "当前页码", required = true) @PathVariable Long current,
                                                      @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable Long limit)
    {
        // 封装条件
        CourseQueryVo courseQueryVo = new CourseQueryVo();
        courseQueryVo.setSubjectParentId(subjectParentId);

        // 创建 page 对象
        Page<Course> coursePageParam = new Page<>(current, limit);
        Map<String, Object> coursePageMap = courseService.findCoursePage(coursePageParam, courseQueryVo);
        return Result.ok(coursePageMap);
    }

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 查询课程详情信息", description = "根据课程 id 查询课程详情信息")
    @GetMapping("get/info/{courseId}")
    public Result<Map<String, Object>> getCourseInfo(
            @Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable Long courseId)
    {
        Map<String, Object> courseInfoMap = courseService.getInfoById(courseId);

        return Result.ok(courseInfoMap);
    }

    /**
     * 根据课程 id 查询课程信息
     *
     * @param courseId 课程 id
     * @return 课程信息
     */
    @Operation(summary = "根据课程 id 查询课程信息", description = "根据课程 id 查询课程信息")
    @GetMapping("inner/get/by/id/{courseId}")
    public Course getById(@Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable("courseId") Long courseId)
    {
        Course course = courseService.getById(courseId);

        return course;
    }
}
