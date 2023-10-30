package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 前端控制器
 * </p>
 */
@Tag(name = "课程分类接口", description = "课程分类管理接口")
@RestController
@RequestMapping(value = "/admin/vod/subject")
// @CrossOrigin
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询课程分类", description = "查询下一层的课程分类")
    @GetMapping("get/child/subject/{id}")
    public Result<List<Subject>> getChildSubject(@Parameter(name = "id", description = "ID", required = true)
                                                 @PathVariable("id") Long id)
    {
        List<Subject> list = subjectService.selectSubjectList(id);

        return Result.ok(list);
    }

    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    @Operation(summary = "课程分类导出", description = "课程分类导出为 Excel")
    @GetMapping("export/data")
    public void exportData(HttpServletResponse response)
    {
        subjectService.exportData(response);
    }

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "课程分类导入", description = "从 Excel 导入课程分类")
    @PostMapping(value = "import/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<Void> importData(@RequestParam("file") MultipartFile file)
    {
        subjectService.importData(file);

        return Result.ok(null);
    }
}
