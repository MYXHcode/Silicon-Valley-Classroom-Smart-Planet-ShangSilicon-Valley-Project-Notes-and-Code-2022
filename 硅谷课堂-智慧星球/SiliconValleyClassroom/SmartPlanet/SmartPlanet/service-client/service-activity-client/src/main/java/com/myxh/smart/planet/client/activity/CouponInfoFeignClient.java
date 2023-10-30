package com.myxh.smart.planet.client.activity;

import com.myxh.smart.planet.model.activity.CouponInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@FeignClient("service-activity")
public interface CouponInfoFeignClient
{
    @Operation(summary = "根据优惠券 id 查询优惠券", description = "根据优惠券 id 查询优惠券")
    @GetMapping(value = "/api/activity/coupon/info/inner/get/by/id/{couponId}")
    CouponInfo getById(@PathVariable("couponId") Long couponId);

    @Operation(summary = "更新优惠券使用状态", description = "更新优惠券使用状态")
    @GetMapping(value = "/api/activity/coupon/info/inner/update/coupon/info/use/status/{couponUseId}/{orderId}")
    Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId);
}
