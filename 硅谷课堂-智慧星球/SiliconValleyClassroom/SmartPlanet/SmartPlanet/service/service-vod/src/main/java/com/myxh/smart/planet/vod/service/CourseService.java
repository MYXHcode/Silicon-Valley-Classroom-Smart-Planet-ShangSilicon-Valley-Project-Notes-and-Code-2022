package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务类
 * </p>
 */
public interface CourseService extends IService<Course>
{
    /**
     * 点播课程列表
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePage 课程页面
     */
    Map<String, Object> findPage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo);

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    Long saveCourseInfo(CourseFormVo courseFormVo);

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return CourseFormVo 课程基本信息
     */
    CourseFormVo getCourseInfoById(Long id);

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    Long updateCourseById(CourseFormVo courseFormVo);

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    CoursePublishVo getCoursePublishVo(Long id);

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     */
    void publishCourse(Long id);

    /**
     * 删除课程
     *
     * @param id 课程 id
     */
    void removeCourseById(Long id);

    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo     查询对象
     * @return coursePageMap 课程页面
     */
    Map<String, Object> findCoursePage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo);

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    Map<String, Object> getInfoById(Long courseId);

    /**
     * 查询所有课程
     *
     * @return courseList 所有课程列表
     */
    List<Course> findlist();
}
