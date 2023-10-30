package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.VideoVisitor;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 * <p>
 * 视频来访者记录 服务类
 * </p>
 */
public interface VideoVisitorService extends IService<VideoVisitor>
{
    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return countMap 课程统计数据
     */
    Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
