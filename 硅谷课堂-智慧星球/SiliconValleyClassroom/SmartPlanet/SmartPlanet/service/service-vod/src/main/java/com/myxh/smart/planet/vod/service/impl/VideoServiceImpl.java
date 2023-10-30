package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vod.mapper.VideoMapper;
import com.myxh.smart.planet.vod.service.VideoService;
import com.myxh.smart.planet.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 服务实现类
 * </p>
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService
{
    // @Lazy 注解可以延迟 Bean 的初始化，缓解循环引用
    @Lazy
    // 注入 VodService
    @Autowired
    private VodService vodService;

    /**
     * 根据课程 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程 id
     */
    @Override
    public void removeVideoByCourseId(Long id)
    {
        // 1、根据课程 id，删除小节中的视频
        // 获取课程里面所有小节
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        List<Video> videoList = baseMapper.selectList(wrapper);

        // 遍历获取每个小节中的视频源 id
        for (Video video : videoList)
        {
            String videoSourceId = video.getVideoSourceId();

            // 如果视频源 id 不为空，调用方法删除
            if (!ObjectUtils.isEmpty(videoSourceId))
            {
                vodService.removeVideo(videoSourceId);
            }
        }

        // 2、根据课程 id，删除小节
        baseMapper.delete(wrapper);
    }

    /**
     * 根据章节 id，删除课程视频小节，同时删除视频
     *
     * @param id 章节 id
     */
    public void removeVideoByChapterId(Long id)
    {
        // 1、根据章节 id，删除小节中的视频
        // 获取章节里的所有小节
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", id);
        List<Video> videoList = baseMapper.selectList(wrapper);

        // 遍历获取每个小节中的视频源 id
        for (Video video : videoList)
        {
            String videoSourceId = video.getVideoSourceId();

            // 如果视频源 id 不为空，调用方法删除
            if (!ObjectUtils.isEmpty(videoSourceId))
            {
                vodService.removeVideo(videoSourceId);
            }
        }

        // 2、根据课程 id，删除小节
        baseMapper.delete(wrapper);
    }

    /**
     * 根据课程视频小节 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程视频小节 id
     */
    @Override
    public void removeVideoById(Long id)
    {
        // 1、根据课程视频小节 id，删除视频
        // 获取课程视频小节
        Video video = baseMapper.selectById(id);

        // 获取视频源 id
        String videoSourceId = video.getVideoSourceId();

        // 如果视频源 id 不为空，调用方法删除
        if (!ObjectUtils.isEmpty(videoSourceId))
        {
            vodService.removeVideo(videoSourceId);
        }

        // 2、根据课程视频小节 id，删除小节
        baseMapper.deleteById(id);
    }

    /**
     * 根据课程视频小节 id，修改课程视频小节
     *
     * @param video 课程视频小节数据
     */
    @Override
    public void updateVideoById(Video video)
    {
        Video oldVideo = baseMapper.selectById(video.getId());

        // 如果新的视频源 id 与旧的不相等
        if (!ObjectUtils.isEmpty(oldVideo.getVideoSourceId()) && !oldVideo.getVideoSourceId().equals(video.getVideoSourceId()))
        {
            // 先删除旧视频
            vodService.removeVideo(oldVideo.getVideoSourceId());
        }

        // 再更新课程视频小节
        baseMapper.updateById(video);
    }
}
