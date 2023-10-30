package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.order.service.WXPayService;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "微信支付 API", description = "微信支付 API 接口")
@RestController
@RequestMapping("/api/order/wx/pay")
public class WXPayController
{
    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "微信下单支付", description = "微信下单支付")
    @GetMapping("/create/js/api/{orderNo}")
    public Result<Map<String, Object>> createJsapi(@Parameter(name = "orderNo", description = "订单号", required = true)
                                                   @PathVariable("orderNo") String orderNo)
    {
        Map<String, Object> map = wxPayService.createJsapi(orderNo);

        return Result.ok(map);
    }

    /**
     * 查询支付状态
     *
     * @param orderNo 订单号
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询支付状态", description = "查询支付状态")
    @GetMapping("/query/pay/status/{orderNo}")
    public Result<Object> queryPayStatus(@Parameter(name = "orderNo", description = "订单号", required = true)
                                       @PathVariable("orderNo") String orderNo)
    {
        // 根据订单号调用微信接口查询支付状态
        Map<String, String> resultMap = wxPayService.queryPayStatus(orderNo);

        // 判断支付是否成功，根据微信支付状态接口判断
        if (resultMap == null)
        {
            // 出错
            return Result.fail(null).message("支付出错");
        }

        if ("SUCCESS".equals(resultMap.get("trade_state")))
        {
            // 成功
            // 更改订单状态，处理支付结果
            String outTradeNo = resultMap.get("out_trade_no");
            System.out.println("out_trade_no = " + outTradeNo);
            orderInfoService.updateOrderStatus(outTradeNo);

            return Result.ok(null).message("支付成功");
        }

        return Result.ok(null).message("支付中");
    }
}
