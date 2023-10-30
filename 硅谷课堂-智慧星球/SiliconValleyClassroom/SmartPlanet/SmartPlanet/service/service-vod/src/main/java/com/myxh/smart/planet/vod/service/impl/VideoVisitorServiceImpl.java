package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.VideoVisitor;
import com.myxh.smart.planet.vo.vod.VideoVisitorCountVo;
import com.myxh.smart.planet.vod.mapper.VideoVisitorMapper;
import com.myxh.smart.planet.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 *
 * <p>
 * 视频来访者记录 服务实现类
 * </p>
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService
{
    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return countMap 课程统计数据
     */
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate)
    {
        // 调用 mapper 的方法
        List<VideoVisitorCountVo> videoVisitorVoList = baseMapper.findCount(courseId, startDate, endDate);

        // 创建 countMap 集合
        Map<String, Object> countMap = new HashMap<>();

        // 创建两个 list 集合，一个代表所有日期，一个代表日期对应数量
        // 代表所有日期
        List<String> dateList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getJoinTime)
                .collect(Collectors.toList());

        // 代表日期对应数量
        List<Integer> countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount)
                .collect(Collectors.toList());

        // 放到 countMap 集合
        countMap.put("xData", dateList);
        countMap.put("yData", countList);

        return countMap;
    }
}
