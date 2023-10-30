package com.myxh.smart.planet.excel;

import com.alibaba.excel.EasyExcel;
import com.myxh.smart.planet.excel.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class TestWrite
{
    public static void main(String[] args)
    {
        // 设置文件名称和路径
        String fileName = "service\\service-vod\\src\\test\\resources\\excel\\用户.xlsx";

        // 调用方法
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());
    }

    /**
     * 循环设置要添加的数据，最终封装到list集合中
     *
     * @return list 用户表格
     */
    private static List<User> data()
    {
        List<User> list = new ArrayList<User>();

        for (int i = 1; i <= 10; i++)
        {
            User data = new User();
            data.setId(i);
            data.setName("MYXH" + i);
            list.add(data);
        }

        return list;
    }
}
