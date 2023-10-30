package com.myxh.smart.planet.vod.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
// @CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 点播课程列表
     *
     * @param current       当前页码
     * @param limit         每页记录数
     * @param courseQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取点播课程", description = "获取点播课程列表")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<Map<String, Object>> courseList(@Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
                                                  @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit,
                                                  @Parameter(name = "courseQueryVo", description = "查询对象") CourseQueryVo courseQueryVo)
    {
        Page<Course> coursePageParam = new Page<>(current, limit);
        Map<String, Object> coursePage = courseService.findPage(coursePageParam, courseQueryVo);

        return Result.ok(coursePage);
    }

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加课程基本信息", description = "添加课程基本信息")
    @PostMapping("save")
    public Result<Long> saveCourseInfo(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.saveCourseInfo(courseFormVo);

        return Result.ok(courseId);
    }

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 获取课程信息", description = "根据 id 获取课程信息")
    @GetMapping("get/{id}")
    public Result<CourseFormVo> get(@PathVariable("id") Long id)
    {
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);

        return Result.ok(courseFormVo);
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 修改课程信息", description = "根据 id 修改课程信息")
    @PostMapping("update")
    public Result<Long> updateCourse(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.updateCourseById(courseFormVo);

        return Result.ok(courseId);
    }

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 查询课程发布信息", description = "根据课程 id 查询课程发布信息")
    @GetMapping("get/course/publish/vo/{id}")
    public Result<CoursePublishVo> getCoursePublishVoById(@Parameter(name = "id", description = "课程ID", required = true)
                                                          @PathVariable Long id)
    {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);

        return Result.ok(coursePublishVo);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 最终发布课程", description = "根据课程 id 最终发布课程")
    @PutMapping("publish/course/{id}")
    public Result<Void> publishCourseById(@Parameter(name = "id", description = "课程ID", required = true)
                                          @PathVariable Long id)
    {
        courseService.publishCourse(id);

        return Result.ok(null);
    }

    /**
     * 删除课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程", description = "删除课程")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程ID", required = true)
                               @PathVariable Long id)
    {
        courseService.removeCourseById(id);

        return Result.ok(null);
    }

    /**
     * 查询所有课程
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询所有课程", description = "查询所有课程")
    @GetMapping("find/all")
    public Result<List<Course>> findAll()
    {
        List<Course> courseList = courseService.findlist();

        return Result.ok(courseList);
    }
}
