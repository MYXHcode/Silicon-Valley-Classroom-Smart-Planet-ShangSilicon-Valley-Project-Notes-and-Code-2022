package com.myxh.smart.planet.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myxh.smart.planet.excel.entity.User;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class ExcelListener extends AnalysisEventListener<User>
{


    /**
     * 一行一行读取 excel 内容，把每行内容封装到 User 对象
     * 从 excel 第二行开始读取
     *
     * @param data            one row value. It is same as {@link AnalysisContext#readRowHolder()} 一行值。与 ｛@link AnalysisContext#readRowHolder()｝ 相同
     * @param analysisContext analysis context 分析上下文
     */
    @Override
    public void invoke(User data, AnalysisContext analysisContext)
    {
        System.out.println(data);
    }

    /**
     * 读取表头内容
     *
     * @param headMap 表头信息
     * @param context 上下文
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context)
    {
        System.out.println("表头信息：" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
