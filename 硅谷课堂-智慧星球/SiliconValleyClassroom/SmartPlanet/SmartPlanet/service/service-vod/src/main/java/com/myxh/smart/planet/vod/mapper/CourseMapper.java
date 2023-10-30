package com.myxh.smart.planet.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vo.vod.CourseVo;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 Mapper 接口
 * </p>
 */
public interface CourseMapper extends BaseMapper<Course>
{
    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    CoursePublishVo selectCoursePublishVoById(Long id);

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    CourseVo selectCourseVoById(Long courseId);
}
