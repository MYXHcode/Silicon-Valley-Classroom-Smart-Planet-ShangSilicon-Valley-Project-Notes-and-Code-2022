package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.vod.mapper.CourseDescriptionMapper;
import com.myxh.smart.planet.vod.service.CourseDescriptionService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程简介 服务实现类
 * </p>
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService
{
    /**
     * 根据课程 id 删除描述
     *
     * @param id 课程 id
     */
    @Override
    public void removeByCourseId(Long id)
    {
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
