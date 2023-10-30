package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vo.vod.VideoVo;
import com.myxh.smart.planet.vod.mapper.ChapterMapper;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务实现类
 * </p>
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService
{
    @Autowired
    private VideoService videoService;

    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return chapterVoList 章节和小节列表
     */
    @Override
    public List<ChapterVo> getNestedTreeList(Long courseId)
    {
        // 定义章节和小节列表 List 集合
        List<ChapterVo> chapterVoList = new ArrayList<>();

        // 根据 courseId 获取课程里面所有章节
        QueryWrapper<Chapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(chapterQueryWrapper);

        // 根据 courseId 获取课程里面所有小节
        LambdaQueryWrapper<Video> videoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        videoLambdaQueryWrapper.eq(Video::getCourseId, courseId);
        videoLambdaQueryWrapper.orderByAsc(Video::getSort, Video::getId);
        List<Video> videoList = videoService.list(videoLambdaQueryWrapper);

        // 封装章节
        // 遍历所有的章节
        for (Chapter chapter : chapterList)
        {
            // 创建 ChapterVo 对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            // 封装章节里面的小节
            // 创建 List 集合用来封装章节所有小节
            List<VideoVo> videoVoList = new ArrayList<>();

            // 遍历小节 List
            for (Video video : videoList)
            {
                // 判断小节是哪个章节下面
                if (chapter.getId().equals(video.getChapterId()))
                {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }

            // 把章节里面所有小节集合放到每个章节里面
            chapterVo.setChildren(videoVoList);
        }

        return chapterVoList;
    }

    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    @Override
    public void removeChapterByCourseId(Long id)
    {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
