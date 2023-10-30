package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Subject;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务类
 * </p>
 */
public interface SubjectService extends IService<Subject>
{
    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return subjectList 下一层的课程分类列表
     */
    List<Subject> selectSubjectList(Long id);

    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    void exportData(HttpServletResponse response);

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     */
    void importData(MultipartFile file);
}
