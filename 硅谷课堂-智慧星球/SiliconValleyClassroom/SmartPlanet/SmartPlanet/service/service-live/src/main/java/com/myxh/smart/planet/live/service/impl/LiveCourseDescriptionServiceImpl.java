package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseDescriptionMapper;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程简介 服务实现类
 * </p>
 */
@Service
public class LiveCourseDescriptionServiceImpl extends ServiceImpl<LiveCourseDescriptionMapper, LiveCourseDescription> implements LiveCourseDescriptionService
{
    /**
     * 获取直播课程描述信息
     *
     * @param id id
     * @return liveCourseDescription 直播课程描述信息
     */
    @Override
    public LiveCourseDescription getLiveCourseDescriptionByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseDescription> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseDescription::getLiveCourseId, id);
        LiveCourseDescription liveCourseDescription = baseMapper.selectOne(wrapper);

        return liveCourseDescription;
    }
}
