package com.myxh.smart.planet.order.service;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public interface WXPayService
{
    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return result 结果
     */
    Map<String, Object> createJsapi(String orderNo);

    /**
     * 根据订单号调用微信接口查询支付状态
     *
     * @param orderNo 订单号
     * @return resultMap 结果
     */
    Map<String, String> queryPayStatus(String orderNo);
}
