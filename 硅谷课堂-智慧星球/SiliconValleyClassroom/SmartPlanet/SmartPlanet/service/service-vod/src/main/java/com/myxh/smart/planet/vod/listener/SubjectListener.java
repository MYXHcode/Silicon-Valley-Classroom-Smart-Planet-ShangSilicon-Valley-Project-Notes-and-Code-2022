package com.myxh.smart.planet.vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.vo.vod.SubjectEeVo;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/6
 */
@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo>
{
    // 注入 subjectMapper
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 一行一行读取 excel 内容，把每行内容封装到 User 对象
     * 从 excel 第二行开始读取
     *
     * @param subjectEeVo     one row value. It is same as {@link AnalysisContext#readRowHolder()} 一行值。与 ｛@link AnalysisContext#readRowHolder()｝ 相同
     * @param analysisContext analysis context 分析上下文
     */
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext)
    {
        //  SubjectEeVo 转换为 Subject
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo, subject);

        // 添加 subject
        subjectMapper.insert(subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
