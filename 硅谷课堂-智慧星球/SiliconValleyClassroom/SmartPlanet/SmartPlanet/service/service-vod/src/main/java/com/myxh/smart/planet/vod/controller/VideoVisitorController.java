package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VideoVisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 * <p>
 * 视频来访者记录 前端控制器
 * </p>
 */
@Tag(name = "视频来访者记录接口", description = "视频来访者记录管理接口")
@RestController
@RequestMapping("admin/vod/video/visitor")
// @CrossOrigin
public class VideoVisitorController
{
    @Autowired
    private VideoVisitorService videoVisitorService;

    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "显示课程统计数据", description = "显示课程统计数据")
    @GetMapping("find/count/{courseId}/{startDate}/{endDate}")
    public Result<Map<String, Object>> showChart(
            @Parameter(name = "courseId", description = "课程ID") @PathVariable("courseId") Long courseId,
            @Parameter(name = "startDate", description = "开始时间") @PathVariable("startDate") String startDate,
            @Parameter(name = "endDate", description = "结束时间") @PathVariable("endDate") String endDate)
    {
        Map<String, Object> countMap = videoVisitorService.findCount(courseId, startDate, endDate);

        return Result.ok(countMap);
    }
}
