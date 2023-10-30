package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.vod.*;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    /**
     * 点播课程列表
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePage 课程页面
     */
    @Override
    public Map<String, Object> findPage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo)
    {
        // 获取条件值
        // 名称
        String title = courseQueryVo.getTitle();

        // 二级分类
        Long subjectId = courseQueryVo.getSubjectId();

        // 一级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        // 教师
        Long teacherId = courseQueryVo.getTeacherId();

        // 封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        if (StringUtils.hasLength(title))
        {
            wrapper.like("title", title);
        }
        if (!ObjectUtils.isEmpty(subjectId))
        {
            wrapper.eq("subject_id", subjectId);
        }
        if (!ObjectUtils.isEmpty(subjectParentId))
        {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!ObjectUtils.isEmpty(teacherId))
        {
            wrapper.eq("teacher_id", teacherId);
        }

        // 调用方法实现条件查询分页
        Page<Course> coursePage = baseMapper.selectPage(coursePageParam, wrapper);

        // 总记录数
        Long totalCount = coursePage.getTotal();

        // 总页数
        Long totalPage = coursePage.getPages();

        // 每页数据集合
        List<Course> coursePageRecords = coursePage.getRecords();

        // 遍历封装教师和分类名称，获取 id 对应名称，进行封装，最终显示
        coursePageRecords.stream().forEach(this::getTeacherOrSubjectName);

        // 封装返回数据
        Map<String, Object> coursePageMap = new HashMap<>();
        coursePageMap.put("totalCount", totalCount);
        coursePageMap.put("totalPage", totalPage);
        coursePageMap.put("records", coursePageRecords);

        return coursePageMap;
    }

    /**
     * 获取教师和分类名称
     *
     * @param course 课程数据
     * @return course 课程数据
     */
    private Course getTeacherOrSubjectName(Course course)
    {
        // 根据教师 id 获取教师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());

        if (teacher != null)
        {
            course.getParam().put("teacherName", teacher.getName());
        }

        // 根据课程分类 id 获取课程分类名称
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());

        if (subjectOne != null)
        {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }

        Subject subjectTwo = subjectService.getById(course.getSubjectId());

        if (subjectTwo != null)
        {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo)
    {
        // 添加课程基本信息，操作 course 表
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        // 添加课程详情信息，操作 course_description 表
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.save(courseDescription);

        // 返回课程 id
        return course.getId();
    }

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return CourseFormVo 课程基本信息
     */
    @Override
    public CourseFormVo getCourseInfoById(Long id)
    {
        // 从 course 表中获取课程基本信息
        Course course = baseMapper.selectById(id);

        if (course == null)
        {
            return null;
        }

        //从 course_description 表中获取课程描述信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);

        // 封装描述信息，创建 CourseFormVo 对象
        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo);

        if (courseDescription != null)
        {
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public Long updateCourseById(CourseFormVo courseFormVo)
    {
        // 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        // 修改课程详情信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", course.getId());
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程描述 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.updateById(courseDescription);

        // 返回课程 id
        return course.getId();
    }

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    @Override
    public CoursePublishVo getCoursePublishVo(Long id)
    {
        return baseMapper.selectCoursePublishVoById(id);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     */
    @Override
    public void publishCourse(Long id)
    {
        Course course = baseMapper.selectById(id);

        // 已经发布课程
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    /**
     * 删除课程
     *
     * @param id 课程 id
     */
    @Override
    public void removeCourseById(Long id)
    {
        // 根据课程 id 删除小节
        videoService.removeVideoByCourseId(id);

        // 根据课程 id 删除章节
        chapterService.removeChapterByCourseId(id);

        // 根据课程 id 删除描述
        courseDescriptionService.removeByCourseId(id);

        // 根据课程 id 删除课程
        baseMapper.deleteById(id);
    }

    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePageMap 课程页面
     */
    @Override
    public Map<String, Object> findCoursePage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo)
    {
        // 获取条件值
        // 课程名称
        String title = courseQueryVo.getTitle();

        // 二级分类
        Long subjectId = courseQueryVo.getSubjectId();

        // 一级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        // 教师
        Long teacherId = courseQueryVo.getTeacherId();

        // 判断条件值是否为空，封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        if (StringUtils.hasLength(title))
        {
            wrapper.like("title", title);
        }

        if (!ObjectUtils.isEmpty(subjectId))
        {
            wrapper.eq("subject_id", subjectId);
        }

        if (!ObjectUtils.isEmpty(subjectParentId))
        {
            wrapper.eq("subject_parent_id", subjectParentId);
        }

        if (!ObjectUtils.isEmpty(teacherId))
        {
            wrapper.eq("teacher_id", teacherId);
        }

        // 调用方法进行条件分页查询
        Page<Course> pages = baseMapper.selectPage(coursePageParam, wrapper);

        // 获取分页数据
        // 总记录数
        long totalCount = pages.getTotal();

        // 总页数
        long totalPage = pages.getPages();

        // 每页数据集合
        List<Course> coursePageRecords = pages.getRecords();

        // 封装其他数据（获取教师名称和课程分类名称)
        coursePageRecords.stream().forEach(this::getTeacherAndSubjectName);

        Map<String, Object> coursePageMap = new HashMap<>();
        coursePageMap.put("totalCount", totalCount);
        coursePageMap.put("totalPage", totalPage);
        coursePageMap.put("records", coursePageRecords);

        return coursePageMap;
    }

    /**
     * 获取教师和分类名称
     *
     * @param course 课程数据
     * @return course 课程数据
     */
    private Course getTeacherAndSubjectName(Course course)
    {
        // 教师名称
        Long teacherId = course.getTeacherId();
        Teacher teacher = teacherService.getById(teacherId);

        if (teacher != null)
        {
            course.getParam().put("teacherName", teacher.getName());
        }

        // 课程分类名称
        Long subjectParentId = course.getSubjectParentId();
        Subject subjectOne = subjectService.getById(subjectParentId);

        if (subjectOne != null)
        {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }

        Long subjectId = course.getSubjectId();
        Subject subjectTwo = subjectService.getById(subjectId);

        if (subjectTwo != null)
        {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    @Override
    public Map<String, Object> getInfoById(Long courseId)
    {
        // 更新浏览数量
        Course course = baseMapper.selectById(courseId);
        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);

        // 课程详情数据
        CourseVo courseVo = baseMapper.selectCourseVoById(courseId);

        // 课程章节小节数据
        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);

        // 课程描述信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);

        // 课程所属教师信息
        Teacher teacher = teacherService.getById(course.getTeacherId());

        // 是否购买，后续完善
        Boolean isBuy = false;

        // 封装 map 集合，返回数据
        Map<String, Object> courseInfoMap = new HashMap<>();
        courseInfoMap.put("courseVo", courseVo);
        courseInfoMap.put("chapterVoList", chapterVoList);
        courseInfoMap.put("description", courseDescription != null ? courseDescription.getDescription() : "");
        courseInfoMap.put("teacher", teacher);

        // 是否购买
        courseInfoMap.put("isBuy", isBuy);

        return courseInfoMap;
    }

    /**
     * 查询所有课程
     *
     * @return courseList 所有课程列表
     */
    @Override
    public List<Course> findlist()
    {
        List<Course> courseList = baseMapper.selectList(null);

        courseList.stream().forEach(this::getTeacherAndSubjectName);

        return courseList;
    }
}
