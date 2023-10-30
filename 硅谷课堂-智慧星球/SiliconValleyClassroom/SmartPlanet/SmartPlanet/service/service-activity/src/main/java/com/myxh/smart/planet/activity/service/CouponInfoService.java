package com.myxh.smart.planet.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 服务类
 * </p>
 */
public interface CouponInfoService extends IService<CouponInfo>
{
    /**
     * 优惠券信息列表
     *
     * @param couponUsePageParam 优惠券使用页面参数
     * @param couponUseQueryVo 查询对象
     * @return couponUsePageModel 优惠券使用页面
     */
    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> couponUsePageParam, CouponUseQueryVo couponUseQueryVo);

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     */
    void updateCouponInfoUseStatus(Long couponUseId, Long orderId);
}
