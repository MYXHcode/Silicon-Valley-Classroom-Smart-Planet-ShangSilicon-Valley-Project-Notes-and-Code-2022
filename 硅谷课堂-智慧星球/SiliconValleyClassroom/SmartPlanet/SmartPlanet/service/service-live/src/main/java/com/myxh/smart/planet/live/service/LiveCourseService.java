package com.myxh.smart.planet.live.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import com.myxh.smart.planet.vo.live.LiveCourseVo;

import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 条件查询直播课程分页列表
     *
     * @param liveCoursePageParam 直播课程页面参数
     * @return LiveCoursePageModel 直播课程页面
     */
    IPage<LiveCourse> selectPage(Page<LiveCourse> liveCoursePageParam);

    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    void saveLive(LiveCourseFormVo liveCourseFormVo);

    /**
     * 删除直播课程
     *
     * @param id id
     */
    void removeLive(Long id);

    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return liveCourseFormVo 直播课程
     */
    LiveCourseFormVo getLiveCourseFormVo(Long id);

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    void updateLiveById(LiveCourseFormVo liveCourseFormVo);

    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return liveCourseConfigVo 直播配置信息
     */
    LiveCourseConfigVo getCourseConfig(Long id);

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    void updateCourseConfig(LiveCourseConfigVo liveCourseConfigVo);

    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    List<LiveCourseVo> getLatelyList();

    /**
     * 获取用户 access_token
     *
     * @param id     id 直播课程 id
     * @param userId 用户 id
     * @return accessToken 访问令牌
     */
    JSONObject getAccessToken(Long id, Long userId);

    /**
     * 根据直播课程 id 查询直播课程信息
     *
     * @param liveCourseId 直播课程 id
     * @return liveCourseInfo 直播课程信息
     */
    Map<String, Object> getInfoById(Long liveCourseId);
}
