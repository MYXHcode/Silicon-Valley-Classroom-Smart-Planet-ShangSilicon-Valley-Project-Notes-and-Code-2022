package com.myxh.smart.planet.client.course;

import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.Teacher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@FeignClient("service-vod")
public interface CourseFeignClient
{
    @Operation(summary = "根据关键字查询课程", description = "根据关键字查询课程")
    @GetMapping("/api/vod/course/inner/find/by/keyword/{keyword}")
    List<Course> findByKeyword(@PathVariable("keyword") String keyword);

    @Operation(summary = "根据课程 id 查询课程信息", description = "根据课程 id 查询课程信息")
    @GetMapping("/api/vod/course/inner/get/by/id/{courseId}")
    Course getById(@Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable("courseId") Long courseId);

    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("admin/vod/teacher/inner/get/teacher/{id}")
    Teacher getTeacherLive(@Parameter(name = "id", description = "ID", required = true) @PathVariable("id") Long id);
}
