package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 前端控制器
 * </p>
 */
@Tag(name = "课程视频小节接口", description = "课程视频小节管理接口")
@RestController
@RequestMapping("/admin/vod/video")
// @CrossOrigin
public class VideoController
{
    @Autowired
    private VideoService videoService;

    /**
     * 获取课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取课程视频小节", description = "获取课程视频小节")
    @GetMapping("get/{id}")
    public Result<Video> get(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                             @PathVariable("id") Long id)
    {
        Video video = videoService.getById(id);

        return Result.ok(video);
    }

    /**
     * 新增课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "新增课程视频小节", description = "新增课程视频小节")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Video video)
    {
        videoService.save(video);

        return Result.ok(null);
    }

    /**
     * 修改课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改课程视频小节", description = "修改课程视频小节")
    @PostMapping("update")
    public Result<Void> update(@RequestBody Video video)
    {
        videoService.updateVideoById(video);

        return Result.ok(null);
    }

    /**
     * 删除课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程视频小节", description = "删除课程视频小节")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                               @PathVariable("id") Long id)
    {
        videoService.removeVideoById(id);

        return Result.ok(null);
    }
}
