package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.CourseDescription;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程简介 服务类
 * </p>
 */
public interface CourseDescriptionService extends IService<CourseDescription>
{
    /**
     * 根据课程 id 删除描述
     *
     * @param id 课程 id
     */
    void removeByCourseId(Long id);
}
