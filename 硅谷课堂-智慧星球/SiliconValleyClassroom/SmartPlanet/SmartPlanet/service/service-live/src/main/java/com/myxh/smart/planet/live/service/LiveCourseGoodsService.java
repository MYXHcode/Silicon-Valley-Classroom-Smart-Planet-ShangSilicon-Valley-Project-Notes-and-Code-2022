package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseGoods;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程关联推荐 服务类
 * </p>
 */
public interface LiveCourseGoodsService extends IService<LiveCourseGoods>
{
    /**
     * 查询直播课程商品列表
     *
     * @param id id
     * @return liveCourseGoodsList 直播课程商品列表
     */
    List<LiveCourseGoods> getLiveCourseGoodsByLiveCourseId(Long id);
}
