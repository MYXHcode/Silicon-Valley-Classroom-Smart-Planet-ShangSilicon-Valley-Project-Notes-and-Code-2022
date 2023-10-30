package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.order.OrderFormVo;
import com.myxh.smart.planet.vo.order.OrderInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "订单信息 API", description = "订单信息 API 接口")

@RestController
@RequestMapping("api/order/order/info")
public class OrderInfoApiController
{
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @param request     请求
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "新增点播课程订单", description = "新增点播课程订单")
    @PostMapping("submit/order")
    public Result<Long> submitOrder(@RequestBody OrderFormVo orderFormVo, HttpServletRequest request)
    {
        // 返回订单 id
        Long orderId = orderInfoService.submitOrder(orderFormVo);

        return Result.ok(orderId);
    }

    /**
     * 根据订单 id 获取订单信息
     *
     * @param id 订单 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据订单 id 获取订单信息", description = "根据订单 id 获取订单信息")
    @GetMapping("get/info/{id}")
    public Result<OrderInfoVo> getInfo(@PathVariable("id") Long id)
    {
        OrderInfoVo orderInfoVo = orderInfoService.getOrderInfoVoById(id);

        return Result.ok(orderInfoVo);
    }
}
