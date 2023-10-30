package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseConfig;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程配置 服务类
 * </p>
 */
public interface LiveCourseConfigService extends IService<LiveCourseConfig>
{
    /**
     * 根据课程 id 查询直播课程配置信息
     *
     * @param id id
     * @return liveCourseConfig 直播课程配置信息
     */
    LiveCourseConfig getLiveCourseConfigByLiveCourseId(Long id);
}
