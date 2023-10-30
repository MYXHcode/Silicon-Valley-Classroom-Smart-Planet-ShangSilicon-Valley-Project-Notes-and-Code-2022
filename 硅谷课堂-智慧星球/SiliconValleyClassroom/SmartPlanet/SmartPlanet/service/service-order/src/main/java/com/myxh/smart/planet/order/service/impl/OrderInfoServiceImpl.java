package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.activity.CouponInfoFeignClient;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.order.OrderDetail;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.order.OrderNoUtils;
import com.myxh.smart.planet.order.mapper.OrderInfoMapper;
import com.myxh.smart.planet.order.service.OrderDetailService;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.ResultCodeEnum;
import com.myxh.smart.planet.vo.order.OrderFormVo;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;
import com.myxh.smart.planet.vo.order.OrderInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务实现类
 * </p>
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService
{
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CouponInfoFeignClient couponInfoFeignClient;

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;


    /**
     * 订单信息列表
     *
     * @param orderInfoPageParam 订单信息页面参数
     * @param orderInfoQueryVo   查询对象
     * @return orderInfoPage 订单信息页面
     */
    @Override
    public Map<String, Object> selectOrderInfoPage(Page<OrderInfo> orderInfoPageParam, OrderInfoQueryVo orderInfoQueryVo)
    {
        // orderInfoQueryVo 获取查询条件
        Long userId = orderInfoQueryVo.getUserId();
        String outTradeNo = orderInfoQueryVo.getOutTradeNo();
        String phone = orderInfoQueryVo.getPhone();
        String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
        String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
        Integer orderStatus = orderInfoQueryVo.getOrderStatus();

        // 判断条件值是否为空，不为空，进行条件封装
        QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();

        if (!ObjectUtils.isEmpty(orderStatus))
        {
            wrapper.eq("order_status", orderStatus);
        }
        if (!ObjectUtils.isEmpty(userId))
        {
            wrapper.eq("user_id", userId);
        }
        if (StringUtils.hasLength(outTradeNo))
        {
            wrapper.eq("out_trade_no", outTradeNo);
        }
        if (StringUtils.hasLength(phone))
        {
            wrapper.eq("phone", phone);
        }
        if (StringUtils.hasLength(createTimeBegin))
        {
            wrapper.ge("create_time", createTimeBegin);
        }
        if (StringUtils.hasLength(createTimeEnd))
        {
            wrapper.le("create_time", createTimeEnd);
        }

        // 调用实现条件分页查询
        Page<OrderInfo> pages = baseMapper.selectPage(orderInfoPageParam, wrapper);
        Long totalCount = pages.getTotal();
        Long pageCount = pages.getPages();
        List<OrderInfo> records = pages.getRecords();

        // 订单里面包含详情内容，封装详情数据，根据订单 id 查询详情
        records.stream().forEach(this::getOrderDetail);

        // 所有需要数据封装 map 集合，最终返回
        Map<String, Object> orderInfoPage = new HashMap<>();
        orderInfoPage.put("total", totalCount);
        orderInfoPage.put("pageCount", pageCount);
        orderInfoPage.put("records", records);

        return orderInfoPage;
    }

    /**
     * 查询订单详情数据
     *
     * @param orderInfo 订单信息
     * @return orderInfo 订单信息
     */
    private OrderInfo getOrderDetail(OrderInfo orderInfo)
    {
        // 订单 id
        Long id = orderInfo.getId();

        // 查询订单详情
        OrderDetail orderDetail = orderDetailService.getById(id);

        if (orderDetail != null)
        {
            String courseName = orderDetail.getCourseName();
            orderInfo.getParam().put("courseName", courseName);
        }

        return orderInfo;
    }

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @return orderId 订单 id
     */
    @Override
    public Long submitOrder(OrderFormVo orderFormVo)
    {
        // 1、获取生成订单条件值
        Long userId = AuthContextHolder.getUserId();
        Long courseId = orderFormVo.getCourseId();
        Long couponId = orderFormVo.getCouponId();

        // 2、判断当前用户是否已有当前课程的订单
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getUserId, userId);
        queryWrapper.eq(OrderDetail::getCourseId, courseId);
        OrderDetail orderDetailExist = orderDetailService.getOne(queryWrapper);

        if (orderDetailExist != null)
        {
            // 如果订单已存在，则直接返回订单 id
            return orderDetailExist.getId();
        }

        // 3、根据课程 id 查询课程信息
        Course course = courseFeignClient.getById(courseId);

        if (course == null)
        {
            throw new SmartPlanetException(ResultCodeEnum.DATA_ERROR.getCode(), ResultCodeEnum.DATA_ERROR.getMessage());
        }

        // 4、根据用户 id 查询用户信息
        UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

        if (userInfo == null)
        {
            throw new SmartPlanetException(ResultCodeEnum.DATA_ERROR.getCode(), ResultCodeEnum.DATA_ERROR.getMessage());
        }

        // 5、根据优惠券 id 查询优惠券信息
        // 优惠券金额
        BigDecimal couponReduce = new BigDecimal(0);

        if (null != couponId)
        {
            CouponInfo couponInfo = couponInfoFeignClient.getById(couponId);
            couponReduce = couponInfo.getAmount();
        }

        // 6、封装订单生成需要数据到对象，完成添加订单
        // 6.1、封装数据到 orderInfo 对象里面，添加订单基本信息表
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setNickName(userInfo.getNickName());
        orderInfo.setPhone(userInfo.getPhone());
        orderInfo.setProvince(userInfo.getProvince());
        orderInfo.setOriginAmount(course.getPrice());
        orderInfo.setCouponReduce(couponReduce);
        orderInfo.setFinalAmount(orderInfo.getOriginAmount().subtract(orderInfo.getCouponReduce()));
        orderInfo.setOutTradeNo(OrderNoUtils.getOrderNo());
        orderInfo.setTradeBody(course.getTitle());
        orderInfo.setOrderStatus("0");
        baseMapper.insert(orderInfo);

        // 6.2、封装数据到 orderDetail 对象里面，添加订单详情信息表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderInfo.getId());
        orderDetail.setUserId(userId);
        orderDetail.setCourseId(courseId);
        orderDetail.setCourseName(course.getTitle());
        orderDetail.setCover(course.getCover());
        orderDetail.setOriginAmount(course.getPrice());
        orderDetail.setCouponReduce(new BigDecimal(0));
        orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
        orderDetailService.save(orderDetail);

        // 7、更新优惠券状态
        if (null != orderFormVo.getCouponUseId())
        {
            couponInfoFeignClient.updateCouponInfoUseStatus(orderFormVo.getCouponUseId(), orderInfo.getId());
        }

        // 8、返回订单 id
        return orderInfo.getId();
    }

    /**
     * 根据订单 id 获取订单信息
     *
     * @param id 订单 id
     * @return orderInfoVo 订单信息
     */
    @Override
    public OrderInfoVo getOrderInfoVoById(Long id)
    {
        //根据订单 id 查询订单基本信息和详情信息
        OrderInfo orderInfo = baseMapper.selectById(id);
        OrderDetail orderDetail = orderDetailService.getById(id);

        // 封装 OrderInfoVo
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        BeanUtils.copyProperties(orderInfo, orderInfoVo);
        orderInfoVo.setCourseId(orderDetail.getCourseId());
        orderInfoVo.setCourseName(orderDetail.getCourseName());

        return orderInfoVo;
    }

    /**
     * 更改订单状态，处理支付结果
     * @param outTradeNo 场外交易编号
     */
    @Override
    public void updateOrderStatus(String outTradeNo)
    {
        // 根据 订单号查询订单
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderInfo::getOutTradeNo,outTradeNo);
        OrderInfo orderInfo = baseMapper.selectOne(wrapper);

        // 更新订单状态，1 已经支付
        orderInfo.setOrderStatus("1");

        // 调用方法更新
        baseMapper.updateById(orderInfo);
    }
}
