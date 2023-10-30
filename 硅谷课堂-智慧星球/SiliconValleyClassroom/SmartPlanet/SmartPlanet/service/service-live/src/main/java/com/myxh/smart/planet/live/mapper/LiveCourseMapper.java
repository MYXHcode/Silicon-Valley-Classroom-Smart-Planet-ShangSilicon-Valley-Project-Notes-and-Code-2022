package com.myxh.smart.planet.live.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 Mapper 接口
 * </p>
 */
public interface LiveCourseMapper extends BaseMapper<LiveCourse>
{
    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    List<LiveCourseVo> findLatelyList();
}
