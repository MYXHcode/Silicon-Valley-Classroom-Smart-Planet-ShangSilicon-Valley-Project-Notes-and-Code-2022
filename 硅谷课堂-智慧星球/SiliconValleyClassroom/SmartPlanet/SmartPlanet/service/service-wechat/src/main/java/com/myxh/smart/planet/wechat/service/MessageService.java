package com.myxh.smart.planet.wechat.service;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
public interface MessageService
{
    /**
     * 接收微信服务器发送来的消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    String receiveMessage(Map<String, String> param);

    /**
     * 推送支付消息，订单成功
     */
    void pushPayMessage(long orderId);
}
