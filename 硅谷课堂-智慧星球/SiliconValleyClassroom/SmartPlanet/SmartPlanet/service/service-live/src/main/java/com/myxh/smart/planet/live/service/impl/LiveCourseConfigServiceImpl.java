package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseConfigMapper;
import com.myxh.smart.planet.live.service.LiveCourseConfigService;
import com.myxh.smart.planet.model.live.LiveCourseConfig;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程配置 服务实现类
 * </p>
 */
@Service
public class LiveCourseConfigServiceImpl extends ServiceImpl<LiveCourseConfigMapper, LiveCourseConfig> implements LiveCourseConfigService
{
    /**
     * 根据课程 id 查询直播课程配置信息
     *
     * @param id id
     * @return liveCourseConfig 直播课程配置信息
     */
    @Override
    public LiveCourseConfig getLiveCourseConfigByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseConfig::getLiveCourseId, id);
        LiveCourseConfig liveCourseConfig = baseMapper.selectOne(wrapper);

        return liveCourseConfig;
    }
}
