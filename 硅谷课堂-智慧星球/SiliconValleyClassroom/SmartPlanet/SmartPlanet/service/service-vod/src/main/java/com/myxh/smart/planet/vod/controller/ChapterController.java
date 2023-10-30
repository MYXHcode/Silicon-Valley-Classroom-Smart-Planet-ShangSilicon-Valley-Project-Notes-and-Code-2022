package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 前端控制器
 * </p>
 */
@Tag(name = "章节接口", description = "章节管理接口")
@RestController
@RequestMapping("/admin/vod/chapter")
// @CrossOrigin
public class ChapterController
{
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "大纲列表", description = "获取获取章节和小节列表")
    @GetMapping("get/nested/tree/list/{courseId}")
    public Result<List<ChapterVo>> getNestedTreeList(@Parameter(name = "courseId", description = "课程ID", required = true)
                                                     @PathVariable("courseId") Long courseId)
    {
        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);

        return Result.ok(chapterVoList);
    }

    /**
     * 添加章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加章节", description = "添加章节")
    @PostMapping("save")
    public Result<Void> saveChapter(@RequestBody Chapter chapter)
    {
        chapterService.save(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 查询章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询章节", description = "根据 id 查询章节")
    @GetMapping("get/{id}")
    public Result<Chapter> getChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        Chapter chapter = chapterService.getById(id);

        return Result.ok(chapter);
    }

    /**
     * 修改章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改章节", description = "修改章节")
    @PostMapping("update")
    public Result<Void> updateChapter(@RequestBody Chapter chapter)
    {
        chapterService.updateById(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 删除章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除章节", description = "根据 id 删除章节")
    @DeleteMapping("remove/{id}")
    public Result<Void> removeChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        // 1、根据章节 id，删除课程视频小节，同时删除视频
        videoService.removeVideoByChapterId(id);

        // 2、根据 id，删除章节
        chapterService.removeById(id);

        return Result.ok(null);
    }
}
