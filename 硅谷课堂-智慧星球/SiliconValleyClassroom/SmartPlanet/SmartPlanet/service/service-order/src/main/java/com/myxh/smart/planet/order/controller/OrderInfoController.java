package com.myxh.smart.planet.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 前端控制器
 * </p>
 */
@Tag(name = "订单信息管理", description = "订单信息管理接口")
@RestController
@RequestMapping("/admin/order/order/info")
public class OrderInfoController
{
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 条件查询订单分页
     *
     * @param current          当前页码
     * @param limit            每页记录数
     * @param orderInfoQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询订单分页", description = "条件查询订单分页")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<Map<String, Object>> orderInfoList(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit,
            @Parameter(name = "orderInfoVo", description = "查询对象")
            OrderInfoQueryVo orderInfoQueryVo)
    {
        // 创建 page 对象
        Page<OrderInfo> orderInfoPageParam = new Page<>(current, limit);
        Map<String, Object> orderInfoPage = orderInfoService.selectOrderInfoPage(orderInfoPageParam, orderInfoQueryVo);

        return Result.ok(orderInfoPage);
    }
}
