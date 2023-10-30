package com.myxh.smart.planet.vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.TeacherQueryVo;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
// 允许跨域请求
// @CrossOrigin
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询所有", description = "查询所有教师")
    @GetMapping("find/all")
    public Result<List<Teacher>> findAllTeacher()
    {
        /*
        try
        {
            // 模拟异常
            int n = 10 / 0;
        }
        catch (Exception e)
        {
            // 抛出异常
            throw new SmartPlanetException(201, "执行 SmartPlanetException 自定义异常处理");
        }
         */

        List<Teacher> teacherList = teacherService.list();

        return Result.ok(teacherList).message("查询所有教师数据成功");
    }

    /**
     * 逻辑删除教师
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除教师")
    @DeleteMapping("remove/{id}")
    public Result<Void> removeTeacher(@Parameter(name = "id", description = "ID", required = true)
                                      @PathVariable("id") Long id)
    {
        boolean isSuccess = teacherService.removeById(id);

        if (isSuccess)
        {
            return Result.<Void>ok(null).message("逻辑删除教师数据成功");
        }
        else
        {
            return Result.<Void>fail(null).message("逻辑删除教师数据失败");
        }
    }

    /**
     * 条件查询教师分页
     *
     * @param current        当前页码
     * @param limit          每页记录数
     * @param teacherQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询分页", description = "条件查询教师分页")
    @PostMapping("find/query/page/{current}/{limit}")
    public Result<IPage<Teacher>> findTeacherPage(@Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
                                                  @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit,
                                                  @Parameter(name = "TeacherQueryVo", description = "查询对象") @RequestBody(required = false) TeacherQueryVo teacherQueryVo)
    {
        // 创建 page 对象，传递当前页和每页记录数
        Page<Teacher> teacherPageParam = new Page<>(current, limit);

        // 判断 teacherQueryVo 对象是否为空
        if (teacherQueryVo == null)
        {
            // 查询所有教师
            IPage<Teacher> teacherPageModel = teacherService.page(teacherPageParam, null);

            return Result.ok(teacherPageModel);
        }
        else
        {
            // 获取条件值
            // 教师名称
            String name = teacherQueryVo.getName();
            // 教师级别
            Integer level = teacherQueryVo.getLevel();
            // 开始时间
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            // 结束时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            // 进行非空判断，条件封装
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

            if (StringUtils.hasLength(name))
            {
                wrapper.like("name", name);
            }
            if (!ObjectUtils.isEmpty(level))
            {
                wrapper.eq("level", level);
            }
            if (StringUtils.hasLength(joinDateBegin))
            {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (StringUtils.hasLength(joinDateEnd))
            {
                wrapper.le("join_date", joinDateEnd);
            }

            //调用方法得到分页查询结果
            IPage<Teacher> teacherPageModel = teacherService.page(teacherPageParam, wrapper);

            // 返回结果
            return Result.ok(teacherPageModel);
        }
    }

    /**
     * 添加教师
     *
     * @param teacher 教师数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加教师")
    @PostMapping("save")
    public Result<Void> saveTeacher(@RequestBody Teacher teacher)
    {
        boolean isSuccess = teacherService.save(teacher);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }

    /**
     * 根据 id 查询教师
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("get/{id}")
    public Result<Teacher> getTeacher(@Parameter(name = "id", description = "ID", required = true) @PathVariable Long id)
    {
        Teacher teacher = teacherService.getById(id);

        return Result.ok(teacher);
    }

    /**
     * 修改教师
     *
     * @param teacher 教师数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改教师")
    @PostMapping("update")
    public Result<Void> updateTeacher(@RequestBody Teacher teacher)
    {
        boolean isSuccess = teacherService.updateById(teacher);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }

    /**
     * 批量删除教师
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除教师")
    @DeleteMapping("remove/batch")
    public Result<Void> removeBatchTeacher(@RequestBody List<Long> idList)
    {
        boolean isSuccess = teacherService.removeByIds(idList);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }

    /**
     * 查询所有教师
     *
     * @return teacherList 所有教师
     */
    /*
    @Operation(summary = "查询", description = "查询所有教师")
    @GetMapping("find/all")
    public List<Teacher> findAllTeacher()
    {
        List<Teacher> teacherList = teacherService.list();

        return teacherList;
    }
     */

    /**
     * 逻辑删除教师
     *
     * @param id id
     * @return isSuccess 是否成功
     */
    /*
    @Operation(summary = "删除", description = "逻辑删除教师")
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@Parameter(name = "id", description = "ID", required = true)
                                 @PathVariable("id") Long id)
    {
        boolean isSuccess = teacherService.removeById(id);

        return isSuccess;
    }
     */

    /**
     * 根据 id 查询教师
     *
     * @param id id
     * @return teacher 教师
     */
    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("inner/get/teacher/{id}")
    public Teacher getTeacherLive(@Parameter(name = "id", description = "ID", required = true) @PathVariable("id") Long id)
    {
        Teacher teacher = teacherService.getById(id);

        return teacher;
    }
}
