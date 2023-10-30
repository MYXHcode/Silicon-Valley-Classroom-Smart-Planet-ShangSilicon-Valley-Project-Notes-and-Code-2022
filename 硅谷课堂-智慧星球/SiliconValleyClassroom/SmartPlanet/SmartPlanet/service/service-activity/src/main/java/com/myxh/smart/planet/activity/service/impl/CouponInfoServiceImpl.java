package com.myxh.smart.planet.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.activity.mapper.CouponInfoMapper;
import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.activity.service.CouponUseService;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService
{
    @Autowired
    private CouponUseService couponUseService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 优惠券信息列表
     *
     * @param couponUsePageParam 优惠券使用页面参数
     * @param couponUseQueryVo   查询对象
     * @return couponUsePageModel 优惠券使用页面
     */
    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> couponUsePageParam, CouponUseQueryVo couponUseQueryVo)
    {
        // 获取条件
        Long couponId = couponUseQueryVo.getCouponId();
        String couponStatus = couponUseQueryVo.getCouponStatus();
        String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
        String getTimeEnd = couponUseQueryVo.getGetTimeEnd();

        // 封装条件
        QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();

        if (!ObjectUtils.isEmpty(couponId))
        {
            wrapper.eq("coupon_id", couponId);
        }
        if (StringUtils.hasLength(couponStatus))
        {
            wrapper.eq("coupon_status", couponStatus);
        }
        if (StringUtils.hasLength(getTimeBegin))
        {
            wrapper.ge("get_time", getTimeBegin);
        }
        if (StringUtils.hasLength(getTimeEnd))
        {
            wrapper.le("get_time", getTimeEnd);
        }

        // 调用方法查询
        IPage<CouponUse> CouponUsePage = couponUseService.page(couponUsePageParam, wrapper);

        // 封装用户昵称和手机号
        List<CouponUse> couponUseList = CouponUsePage.getRecords();

        // 遍历
        couponUseList.stream().forEach(this::getUserInfoByCouponUse);

        return CouponUsePage;
    }

    /**
     * 封装用户昵称和手机号
     *
     * @param couponUse 优惠券使用数据
     * @return couponUse 优惠券使用数据
     */
    private CouponUse getUserInfoByCouponUse(CouponUse couponUse)
    {
        // 获取用户 id
        Long userId = couponUse.getUserId();

        if (!ObjectUtils.isEmpty(userId))
        {
            // 远程调用
            UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

            if (userInfo != null)
            {
                couponUse.getParam().put("nickName", userInfo.getNickName());
                couponUse.getParam().put("phone", userInfo.getPhone());
            }
        }

        return couponUse;
    }

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     */
    @Override
    public void updateCouponInfoUseStatus(Long couponUseId, Long orderId)
    {
        CouponUse couponUse = new CouponUse();
        couponUse.setId(couponUseId);
        couponUse.setOrderId(orderId);
        couponUse.setCouponStatus("1");
        couponUse.setUsingTime(new Date());
        couponUseService.updateById(couponUse);
    }
}
