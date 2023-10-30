package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Video;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 服务类
 * </p>
 */
public interface VideoService extends IService<Video>
{
    /**
     * 根据课程 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程 id
     */
    void removeVideoByCourseId(Long id);

    /**
     * 根据章节 id，删除课程视频小节，同时删除视频
     *
     * @param id 章节 id
     */
    void removeVideoByChapterId(Long id);

    /**
     * 根据课程视频小节 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程视频小节 id
     */
    void removeVideoById(Long id);

    /**
     * 根据课程视频小节 id，修改课程视频小节
     *
     * @param video 课程视频小节数据
     */
    void updateVideoById(Video video);
}
