package com.myxh.smart.planet.order.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.order.HttpClientUtils;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.order.service.WXPayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Service
public class WXPayServiceImpl implements WXPayService
{
    @Autowired
    private OrderInfoService orderInfoService;
    @Resource
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return result 结果
     */
    @Override
    public Map<String, Object> createJsapi(String orderNo)
    {
        try
        {
            // 封装微信支付需要参数，使用 map 集合
            Map<String, String> paramMap = new HashMap<>();

            // 1、设置参数
            // 正式服务公众号商户id = wxf913bfa3a2c7eeeb（固定值）
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");

            // 正式服务公众号商户号 = 1481962542（固定值）
            paramMap.put("mch_id", "1481962542");

            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paramMap.put("body", "test");
            paramMap.put("out_trade_no", orderNo);

            // 为了参数，支付 0.01 元
            paramMap.put("total_fee", "1");
            paramMap.put("spbill_create_ip", "127.0.0.1");
            paramMap.put("notify_url", "http://smartplanet.free.idcfengye.com/api/order/wx/pay/notify");

            // 支付类型，按照生成固定金额支付
            paramMap.put("trade_type", "JSAPI");

            /*
            设置参数值当前微信用户 openid
            现实实现逻辑：第一步、根据订单号获取 userid
                       第二步、根据 userid 获取 openid

            因为当前使用测试号，测试号不支持支付功能，为了使用正式服务公众号进行测试，使用下面写法
            获取正式服务公众号微信 openid
            通过其他方式获取正式服务公众号 openid，直接设置
             */
            // 正式服务公众号 openid = oQTXC56lAy3xMOCkKCImHtHoLL（不定值）
            paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");

            // 2、HTTPClient 来根据 URL 访问第三方接口并且传递参数，调用微信支付接口
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

            // client 设置请求参数
            // 正式服务公众号商户 key = MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9
            String paramXml = WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");
            client.setXmlParam(paramXml);
            client.setHttps(true);

            // 发送请求
            client.post();

            // 3、微信支付接口返回第三方的数据
            String contentXml = client.getContent();
            System.out.println("contentXml = " + contentXml);
            Map<String, String> resultMap = WXPayUtil.xmlToMap(contentXml);

            if ((resultMap.get("result_code") != null) && !"SUCCESS".equals(resultMap.get("result_code")))
            {
                throw new SmartPlanetException(20001, "支付失败");
            }

            // 4、再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(new Date().getTime()));
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            // 返回结果
            Map<String, Object> result = new HashMap<>();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            System.out.println("result = " + result);

            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return new HashMap<>();
        }
    }

    /**
     * 根据订单号调用微信接口查询支付状态
     *
     * @param orderNo 订单号
     * @return resultMap 结果
     */
    @Override
    public Map<String, String> queryPayStatus(String orderNo)
    {
        try
        {
            // 1、封装微信接口需要参数，使用 map
            Map paramMap = new HashMap<>();
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");
            paramMap.put("mch_id", "1481962542");
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());

            // 2、调用接口 Httpclient，设置请求
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));
            client.setHttps(true);
            client.post();

            // 3、封装返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            // 5、返回结果
            return resultMap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
