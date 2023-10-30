package com.myxh.smart.planet.vod.service;

import java.io.InputStream;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/11
 */
public interface VodService
{
    /**
     * 上传视频
     *
     * @param inputStream 输入流
     * @param originalFilename 原始文件名
     * @return videoId 视频 id
     */
    String uploadVideo(InputStream inputStream, String originalFilename);

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     */
    void removeVideo(String videoSourceId);

    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return playAuthMap 播放凭证
     */
    Map<String, Object> getPlayAuth(Long courseId, Long videoId);
}
