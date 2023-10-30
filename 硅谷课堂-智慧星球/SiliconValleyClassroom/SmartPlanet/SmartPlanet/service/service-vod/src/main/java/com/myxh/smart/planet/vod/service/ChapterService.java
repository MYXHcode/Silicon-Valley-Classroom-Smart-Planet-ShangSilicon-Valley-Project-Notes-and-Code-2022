package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.vo.vod.ChapterVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务类
 * </p>
 */
public interface ChapterService extends IService<Chapter>
{
    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return chapterVoList 章节和小节列表
     */
    List<ChapterVo> getNestedTreeList(Long courseId);

    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    void removeChapterByCourseId(Long id);
}
