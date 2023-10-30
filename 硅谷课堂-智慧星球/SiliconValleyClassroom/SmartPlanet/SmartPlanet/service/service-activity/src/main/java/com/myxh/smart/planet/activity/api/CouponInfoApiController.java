package com.myxh.smart.planet.activity.api;

import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "优惠券信息 API", description = "优惠券信息 API 接口")
@RestController
@RequestMapping("/api/activity/coupon/info")
public class CouponInfoApiController
{
    @Autowired
    private CouponInfoService couponInfoService;

    /**
     * 根据优惠券 id 查询优惠券
     *
     * @param couponId 优惠券 id
     * @return 优惠券信息
     */
    @Operation(summary = "根据优惠券 id 查询优惠券", description = "根据优惠券 id 查询优惠券")
    @GetMapping(value = "inner/get/by/id/{couponId}")
    public CouponInfo getById(@PathVariable("couponId") Long couponId)
    {
        CouponInfo couponInfo = couponInfoService.getById(couponId);

        return couponInfo;
    }

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     * @return true 优惠券使用状态
     */
    @Operation(summary = "更新优惠券使用状态", description = "更新优惠券使用状态")
    @GetMapping(value = "inner/update/coupon/info/use/status/{couponUseId}/{orderId}")
    public Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId)
    {
        couponInfoService.updateCouponInfoUseStatus(couponUseId, orderId);

        return true;
    }
}
