package com.myxh.smart.planet.live.api;

import com.alibaba.fastjson2.JSONObject;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/28
 */
@Tag(name = "直播课程 API", description = "直播课程 API 接口")
@RestController
@RequestMapping("api/live/live/course")
public class LiveCourseApiController
{
    @Resource
    private LiveCourseService liveCourseService;

    /**
     * 获取用户 access_token
     *
     * @param id 直播课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取用户 access_token", description = "获取用户 access_token")
    @GetMapping("get/play/auth/{id}")
    public Result<JSONObject> getPlayAuth(@PathVariable("id") Long id)
    {
        JSONObject accessToken = liveCourseService.getAccessToken(id, AuthContextHolder.getUserId());

        return Result.ok(accessToken);
    }

    /**
     * 根据直播课程 id 查询直播课程信息
     *
     * @param liveCourseId 直播课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据直播课程 id 查询直播课程信息", description = "根据直播课程 id 查询直播课程信息")
    @GetMapping("get/info/{liveCourseId}")
    public Result<Map<String, Object>> getInfo(@Parameter(name = "liveCourseId", description = "直播课程 ID", required = true)
                                               @PathVariable("liveCourseId") Long liveCourseId)
    {
        Map<String, Object> liveCourseInfo = liveCourseService.getInfoById(liveCourseId);

        return Result.ok(liveCourseInfo);
    }
}
