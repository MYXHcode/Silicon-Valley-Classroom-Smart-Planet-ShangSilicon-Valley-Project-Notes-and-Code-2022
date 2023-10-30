package com.myxh.smart.planet.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.vod.VideoVisitor;
import com.myxh.smart.planet.vo.vod.VideoVisitorCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 * <p>
 * 视频来访者记录 Mapper 接口
 * </p>
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor>
{
    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return countMap 课程统计数据
     */
    List<VideoVisitorCountVo> findCount(
            @Param("courseId") Long courseId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
}

