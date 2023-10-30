package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseGoodsMapper;
import com.myxh.smart.planet.live.service.LiveCourseGoodsService;
import com.myxh.smart.planet.model.live.LiveCourseGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程关联推荐 服务实现类
 * </p>
 */
@Service
public class LiveCourseGoodsServiceImpl extends ServiceImpl<LiveCourseGoodsMapper, LiveCourseGoods> implements LiveCourseGoodsService
{
    /**
     * 查询直播课程商品列表
     *
     * @param id id
     * @return liveCourseGoodsList 直播课程商品列表
     */
    @Override
    public List<LiveCourseGoods> getLiveCourseGoodsByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseGoods::getLiveCourseId, id);
        List<LiveCourseGoods> liveCourseGoodsList = baseMapper.selectList(wrapper);

        return liveCourseGoodsList;
    }
}
