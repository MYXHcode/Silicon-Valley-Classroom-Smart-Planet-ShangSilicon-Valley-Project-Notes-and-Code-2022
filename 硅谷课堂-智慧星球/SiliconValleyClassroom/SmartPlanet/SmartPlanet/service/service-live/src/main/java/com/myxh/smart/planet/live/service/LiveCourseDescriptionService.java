package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseDescription;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程简介 服务类
 * </p>
 */
public interface LiveCourseDescriptionService extends IService<LiveCourseDescription>
{
    /**
     * 获取直播课程描述信息
     *
     * @param id id
     * @return liveCourseDescription 直播课程描述信息
     */
    LiveCourseDescription getLiveCourseDescriptionByLiveCourseId(Long id);
}
