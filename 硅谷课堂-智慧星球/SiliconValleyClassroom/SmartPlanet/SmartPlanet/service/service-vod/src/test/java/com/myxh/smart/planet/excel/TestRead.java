package com.myxh.smart.planet.excel;

import com.alibaba.excel.EasyExcel;
import com.myxh.smart.planet.excel.entity.User;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class TestRead
{
    public static void main(String[] args)
    {
        // 设置文件名称和路径
        String fileName = "service\\service-vod\\src\\test\\resources\\excel\\用户.xlsx";

        // 调用方法进行读操作
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();
    }
}
