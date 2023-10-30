package com.myxh.smart.planet.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/5
 */
public interface FileService
{
    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    String upload(MultipartFile file);
}
