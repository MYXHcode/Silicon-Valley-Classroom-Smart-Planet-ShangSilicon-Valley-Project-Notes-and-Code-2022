package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/5
 */
@Tag(name = "文件接口", description = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
// @CrossOrigin
public class FileUploadController
{
    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    @Operation(summary = "上传", description = "上传文件")
    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        String url = fileService.upload(file);

        return Result.ok(url).message("上传文件成功");
    }
}
