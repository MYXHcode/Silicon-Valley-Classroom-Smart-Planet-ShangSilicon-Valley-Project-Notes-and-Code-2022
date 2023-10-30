package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VodService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.myxh.smart.planet.vod.utils.Signature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Tag(name = "腾讯云点播接口", description = "腾讯云点播接口")
@RestController
@RequestMapping("/admin/vod")
// @CrossOrigin
public class VodController
{
    @Autowired
    private VodService vodService;

    /**
     * 获取客户端上传视频签名
     *
     * @return signature 视频签名
     */
    @Operation(summary = "视频签名", description = "获取客户端上传视频签名")
    @GetMapping("sign")
    public Result<String> sign()
    {
        Signature sign = new Signature();

        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        sign.setSecretKey(ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));

        // 签名有效期：2天
        sign.setSignValidDuration(3600 * 24 * 2);

        // 设置转码任务流
        sign.setProcedure("LongVideoPreset");

        try
        {
            String signature = sign.getUploadSignature();
            System.out.println("signature = " + signature);

            return Result.ok(signature);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new SmartPlanetException(20001,"获取签名失败");
        }
    }

    /**
     * 上传视频
     *
     * @param file 文件
     * @return videoId 视频 id
     * @throws IOException IO 异常
     */
    @Operation(summary = "上传", description = "上传视频")
    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadVideo(@Parameter(name = "file", description = "文件", required = true)
                                      @RequestParam("file") MultipartFile file) throws IOException
    {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String videoId = vodService.uploadVideo(inputStream, originalFilename);

        return Result.ok(videoId);
    }

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "删除视频")
    @DeleteMapping("remove/{videoSourceId}")
    public Result<Void> removeVideo(@Parameter(name = "videoSourceId", description = "视频源 id", required = true)
                                    @PathVariable("videoSourceId") String videoSourceId)
    {
        vodService.removeVideo(videoSourceId);

        return Result.ok(null);
    }
}
