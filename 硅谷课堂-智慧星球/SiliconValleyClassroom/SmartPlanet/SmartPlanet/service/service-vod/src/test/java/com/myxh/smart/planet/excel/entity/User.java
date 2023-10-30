package com.myxh.smart.planet.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/10/6
 */
@Data
public class User
{
    // 设置表头名称
    @ExcelProperty(value = "用户编号", index = 0)
    private Integer id;

    // 设置表头名称
    @ExcelProperty(value = "用户姓名", index = 1)
    private String name;
}
