package com.myxh.smart.planet.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.vo.vod.SubjectEeVo;
import com.myxh.smart.planet.vod.listener.SubjectListener;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import com.myxh.smart.planet.vod.service.SubjectService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务实现类
 * </p>
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService
{
    @Autowired
    private SubjectListener subjectListener;

    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return subjectList 下一层的课程分类列表
     */
    @Override
    public List<Subject> selectSubjectList(Long id)
    {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);

        // 遍历 subjectList，得到每个 Subject 对象，判断是否有下一层数据，如果有，则向 subjectList 集合每个 Subject 对象中设置 hasChildren
        for (Subject subject : subjectList)
        {
            // 获取 subject 的 id 值
            Long subjectId = subject.getId();

            // 查询
            boolean isChild = this.isChildren(subjectId);

            // 封装到对象里面
            subject.setHasChildren(isChild);
        }

        return subjectList;
    }

    /**
     * 判断 id 下面是否有子节点
     *
     * @param subjectId 课程 id
     * @return isChild 是否有子节点
     */
    private boolean isChildren(Long subjectId)
    {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", subjectId);
        Long count = baseMapper.selectCount(wrapper);

        return count > 0;
    }

    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    @Override
    public void exportData(HttpServletResponse response)
    {

        try
        {
            // 设置下载信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里 URLEncoder.encode 可以防止中文乱码，当然和 easyexcel 没有关系
            String fileName = URLEncoder.encode("课程分类", StandardCharsets.UTF_8);

            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            // 查询课程分类表所有数据
            List<Subject> subjectList = baseMapper.selectList(null);

            // List<Subject> 转换为 List<SubjectEeVo>
            List<SubjectEeVo> subjectEeVoList = new ArrayList<>();

            for (Subject subject : subjectList)
            {
                SubjectEeVo subjectEeVo = new SubjectEeVo();
                // subjectEeVo.setId(subject.getId());
                // subjectEeVo.setParentId(subject.getParentId());
                BeanUtils.copyProperties(subject, subjectEeVo);
                subjectEeVoList.add(subjectEeVo);
            }

            // EasyExcel 写操作
            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class)
                    .sheet("课程分类")
                    .doWrite(subjectEeVoList);
        }
        catch (IOException e)
        {
            throw new SmartPlanetException(20001, "导出失败");
        }
    }

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     */
    @Override
    public void importData(MultipartFile file)
    {
        try
        {
            EasyExcel.read(file.getInputStream(),
                    SubjectEeVo.class,
                    subjectListener).sheet().doRead();
        }
        catch (IOException e)
        {
            throw new SmartPlanetException(20001, "导入失败");
        }
    }
}
