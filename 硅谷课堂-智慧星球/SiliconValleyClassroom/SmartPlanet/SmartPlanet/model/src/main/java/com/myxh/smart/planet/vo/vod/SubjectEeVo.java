package com.myxh.smart.planet.vo.vod;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class SubjectEeVo
{
    @ExcelProperty(value = "ID", index = 0)
    private Long id;

    @ExcelProperty(value = "课程分类名称", index = 1)
    private String title;

    @ExcelProperty(value = "上级ID", index = 2)
    private Long parentId;

    @ExcelProperty(value = "排序", index = 3)
    private Integer sort;
}
