package com.myxh.smart.planet.vod.api;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/20
 */
@Tag(name = "腾讯云点播 API", description = "腾讯云点播 API 接口")
@RestController
@RequestMapping("/api/vod")
public class VodApiController
{
    @Autowired
    private VodService vodService;

    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return Result 全局统一返回结果
     */
    @Operation()
    @GetMapping("get/play/auth/{courseId}/{videoId}")
    public Result<Map<String, Object>> getPlayAuth(
            @Parameter(name = "courseId", description = "课程ID", required = true)
            @PathVariable("courseId") Long courseId,
            @Parameter(name = "videoId", description = "视频ID", required = true)
            @PathVariable("videoId") Long videoId)
    {
        Map<String, Object> playAuthMap = vodService.getPlayAuth(courseId, videoId);

        return Result.ok(playAuthMap);
    }
}
