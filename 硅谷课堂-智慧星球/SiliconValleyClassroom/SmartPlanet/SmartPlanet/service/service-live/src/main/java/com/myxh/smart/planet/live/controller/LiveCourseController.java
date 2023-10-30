package com.myxh.smart.planet.live.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import com.myxh.smart.planet.vo.live.LiveCourseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    /**
     * 条件查询直播课程分页列表
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询直播课程分页列表", description = "条件查询直播课程分页列表")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<IPage<LiveCourse>> index(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit)
    {
        Page<LiveCourse> LiveCoursePageParam = new Page<>(current, limit);
        IPage<LiveCourse> LiveCoursePageModel = liveCourseService.selectPage(LiveCoursePageParam);

        return Result.ok(LiveCoursePageModel);
    }

    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加直播课程", description = "添加直播课程")
    @PostMapping("save")
    public Result<Void> save(@RequestBody LiveCourseFormVo liveCourseFormVo)
    {
        liveCourseService.saveLive(liveCourseFormVo);

        return Result.ok(null);
    }

    /**
     * 删除直播课程
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除直播课程", description = "删除直播课程")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") Long id)
    {
        liveCourseService.removeLive(id);

        return Result.ok(null);
    }

    /**
     * 根据 id 查询直播课程基本信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 查询直播课程基本信息", description = "根据 id 查询直播课程基本信息")
    @GetMapping("get/{id}")
    public Result<LiveCourse> get(@PathVariable("id") Long id)
    {
        LiveCourse liveCourse = liveCourseService.getById(id);

        return Result.ok(liveCourse);
    }

    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 查询直播课程基本信息和描述信息", description = "根据 id 查询直播课程基本信息和描述信息")
    @GetMapping("get/info/{id}")
    public Result<LiveCourseFormVo> getInfo(@PathVariable("id") Long id)
    {
        LiveCourseFormVo liveCourseFormVo = liveCourseService.getLiveCourseFormVo(id);

        return Result.ok(liveCourseFormVo);
    }

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "更新直播课程", description = "更新直播课程")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody LiveCourseFormVo liveCourseFormVo)
    {
        liveCourseService.updateLiveById(liveCourseFormVo);

        return Result.ok(null);
    }

    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取直播账号信息", description = "获取直播账号信息")
    @GetMapping("get/live/course/account/{id}")
    public Result<LiveCourseAccount> getLiveCourseAccount(@PathVariable("id") Long id)
    {
        LiveCourseAccount liveCourseAccount = liveCourseAccountService.getLiveCourseAccountByLiveCourseId(id);

        return Result.ok(liveCourseAccount);
    }

    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取直播配置信息", description = "获取直播配置信息")
    @GetMapping("get/course/config/{id}")
    public Result<LiveCourseConfigVo> getCourseConfig(@PathVariable("id") Long id)
    {
        LiveCourseConfigVo liveCourseConfigVo = liveCourseService.getCourseConfig(id);

        return Result.ok(liveCourseConfigVo);
    }

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改直播配置信息", description = "修改直播配置信息")
    @PutMapping("update/config")
    public Result<Void> updateConfig(@RequestBody LiveCourseConfigVo liveCourseConfigVo)
    {
        liveCourseService.updateCourseConfig(liveCourseConfigVo);

        return Result.ok(null);
    }

    /**
     * 获取最近的直播
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取最近的直播", description = "获取最近的直播")
    @GetMapping("find/lately/list")
    public Result<List<LiveCourseVo>> findLatelyList()
    {
        List<LiveCourseVo> liveCourseVoList = liveCourseService.getLatelyList();

        return Result.ok(liveCourseVoList);
    }
}
