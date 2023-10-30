package com.myxh.smart.planet.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * @author MYXH
 * @date 2023/10/21
 * @description 订单号工具类
 */
public class OrderNoUtils
{
    /**
     * 获取订单号
     *
     * @return 订单号
     */
    public static String getOrderNo()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 3; i++)
        {
            result.append(random.nextInt(10));
        }
        return newDate + result;
    }
}
