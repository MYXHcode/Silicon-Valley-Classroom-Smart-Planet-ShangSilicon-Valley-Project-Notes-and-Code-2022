package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.order.OrderDetail;
import com.myxh.smart.planet.order.mapper.OrderDetailMapper;
import com.myxh.smart.planet.order.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单明细 服务实现类
 * </p>
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService
{

}
