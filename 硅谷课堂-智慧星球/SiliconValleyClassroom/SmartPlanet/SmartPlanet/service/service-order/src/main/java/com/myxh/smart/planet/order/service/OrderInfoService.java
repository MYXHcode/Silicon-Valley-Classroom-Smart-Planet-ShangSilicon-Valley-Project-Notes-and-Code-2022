package com.myxh.smart.planet.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.vo.order.OrderFormVo;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;
import com.myxh.smart.planet.vo.order.OrderInfoVo;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务类
 * </p>
 */
public interface OrderInfoService extends IService<OrderInfo>
{
    /**
     * 订单信息列表
     *
     * @param orderInfoPageParam 订单信息页面参数
     * @param orderInfoQueryVo 查询对象
     * @return orderInfoPage 订单信息页面
     */
    Map<String, Object> selectOrderInfoPage(Page<OrderInfo> orderInfoPageParam, OrderInfoQueryVo orderInfoQueryVo);

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @return orderId 订单 id
     */
    Long submitOrder(OrderFormVo orderFormVo);

    /**
     * 根据订单 id 获取订单信息
     *
     * @param id 订单 id
     * @return orderInfoVo 订单信息
     */
    OrderInfoVo getOrderInfoVoById(Long id);

    /**
     * 更改订单状态，处理支付结果
     * @param outTradeNo 场外交易编号
     */
    void updateOrderStatus(String outTradeNo);
}
