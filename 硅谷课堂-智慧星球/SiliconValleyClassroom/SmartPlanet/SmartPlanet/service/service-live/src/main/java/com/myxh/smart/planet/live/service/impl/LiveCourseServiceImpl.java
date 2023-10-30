package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.*;
import com.myxh.smart.planet.model.live.*;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.order.DateUtil;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import com.myxh.smart.planet.vo.live.LiveCourseGoodsView;
import com.myxh.smart.planet.vo.live.LiveCourseVo;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Autowired
    private MTCloud mtCloudClient;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    @Autowired
    private LiveCourseConfigService liveCourseConfigService;

    @Autowired
    private LiveCourseGoodsService liveCourseGoodsService;

    /**
     * 条件查询直播课程分页列表
     *
     * @param liveCoursePageParam 直播课程页面参数
     * @return LiveCoursePageModel 直播课程页面
     */
    @Override
    public IPage<LiveCourse> selectPage(Page<LiveCourse> liveCoursePageParam)
    {
        // 分页查询
        IPage<LiveCourse> LiveCoursePageModel = baseMapper.selectPage(liveCoursePageParam, null);

        // 获取课程教师信息
        List<LiveCourse> liveCourseList = LiveCoursePageModel.getRecords();

        // 遍历获取直播课程 List 集合
        for (LiveCourse liveCourse : liveCourseList)
        {
            // 获取每个课程教师 id
            Long teacherId = liveCourse.getTeacherId();

            // 根据教师 id 查询教师信息
            Teacher teacher = teacherFeignClient.getTeacherLive(teacherId);

            // 进行封装
            liveCourse.getParam().put("teacherName", teacher.getName());
            liveCourse.getParam().put("teacherLevel", teacher.getLevel());
        }

        return LiveCoursePageModel;
    }

    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void saveLive(LiveCourseFormVo liveCourseFormVo)
    {
        LiveCourse liveCourse = new LiveCourse();
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 获取教师信息
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourseFormVo.getTeacherId());

        // 调用方法添加直播课程
        // 创建 map 集合，封装直播课程其他参数
        HashMap<Object, Object> options = new HashMap<>();

        // 直播类型，1：教育直播，2：生活直播
        // 默认 1，说明：根据平台开通的直播类型填写
        options.put("scenes", 1);
        options.put("password", liveCourseFormVo.getPassword());

        /*
        course_name  课程名称
        bid      发起直播课程的主播账号
        start_time   课程开始时间，格式：2015-01-10 12:00:00
        end_time     课程结束时间，格式：2015-01-10 13:00:00
        nickname     昵称
        accountIntro 主播介绍
        options      其他参数
         */
        String res = mtCloudClient.courseAdd(liveCourse.getCourseName(),
                teacher.getId().toString(),
                new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                teacher.getName(),
                teacher.getIntro(),
                options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        // 把创建之后返回结果进行判断
        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            // 添加直播基本信息
            JSONObject object = commonResult.getData();

            // 直播课程 id
            Long courseId = object.getLong("course_id");
            liveCourse.setCourseId(courseId);
            baseMapper.insert(liveCourse);

            // 添加直播描述信息
            LiveCourseDescription liveCourseDescription = new LiveCourseDescription();
            liveCourseDescription.setLiveCourseId(liveCourse.getId());
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescriptionService.save(liveCourseDescription);

            // 添加直播账号信息
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setAnchorAccount(object.getString("bid"));
            liveCourseAccount.setAnchorPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setAnchorKey(object.getString("zhubo_key"));
            liveCourseAccountService.save(liveCourseAccount);
        }
        else
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "直播创建失败！" + msg);
        }
    }

    /**
     * 删除直播课程
     *
     * @param id id
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void removeLive(Long id)
    {
        // 根据 id 查询直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        if (liveCourse != null)
        {
            // 获取直播 courseId
            Long courseId = liveCourse.getCourseId();

            // 调用方法删除平台直播课程
            String res = mtCloudClient.courseDelete(courseId.toString());
            System.out.println("res = " + res);
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

            // 把删除之后返回结果进行判断
            if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
            {
                // 删除直播基本信息
                baseMapper.deleteById(id);

                // 删除直播描述信息
                liveCourseDescriptionService.remove(new LambdaQueryWrapper<LiveCourseDescription>().ge(LiveCourseDescription::getLiveCourseId, id));

                // 删除直播账号信息
                liveCourseAccountService.remove(new LambdaQueryWrapper<LiveCourseAccount>().ge(LiveCourseAccount::getLiveCourseId, id));
            }
            else
            {
                String msg = commonResult.getMsg();
                System.out.println("msg = " + msg);
                throw new SmartPlanetException(20001, "删除直播课程失败！" + msg);
            }
        }
    }

    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return liveCourseFormVo 直播课程
     */
    @Override
    public LiveCourseFormVo getLiveCourseFormVo(Long id)
    {
        // 获取直播课程基本信息
        LiveCourse liveCourse = this.getById(id);

        // 获取直播课程描述信息
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(id);

        // 封装数据
        LiveCourseFormVo liveCourseFormVo = new LiveCourseFormVo();
        BeanUtils.copyProperties(liveCourse, liveCourseFormVo);
        liveCourseFormVo.setDescription(liveCourseDescription.getDescription());

        return liveCourseFormVo;
    }

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateLiveById(LiveCourseFormVo liveCourseFormVo)
    {
        // 根据 id 获取直播课程基本信息
        LiveCourse liveCourse = baseMapper.selectById(liveCourseFormVo.getId());
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 获取教师信息
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourseFormVo.getTeacherId());

        /*
        course_id 课程ID
        course_name  课程名称
        bid      发起直播课程的主播账号
        start_time   课程开始时间，格式：2015-01-10 12:00:00
        end_time     课程结束时间，格式：2015-01-10 13:00:00
        nickname     昵称
        accountIntro 主播介绍
        options      其他参数
         */
        HashMap<Object, Object> options = new HashMap<>();

        String res = mtCloudClient.courseUpdate(liveCourse.getCourseId().toString(),
                teacher.getId().toString(),
                liveCourse.getCourseName(),
                new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                teacher.getName(),
                teacher.getIntro(),
                options);
        System.out.println("res = " + res);

        // 返回结果转换，判断是否成功
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            JSONObject object = commonResult.getData();

            // 更新直播课程基本信息
            liveCourse.setCourseId(object.getLong("course_id"));
            baseMapper.updateById(liveCourse);

            // 直播课程描述信息更新
            LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(liveCourse.getId());
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescriptionService.update(liveCourseDescription, new LambdaQueryWrapper<LiveCourseDescription>().ge(LiveCourseDescription::getLiveCourseId, liveCourse.getId()));

            // 更新直播账号信息
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setAnchorAccount(object.getString("bid"));
            liveCourseAccount.setAnchorPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setAnchorKey(object.getString("zhubo_key"));
            liveCourseAccountService.update(liveCourseAccount, new LambdaUpdateWrapper<LiveCourseAccount>().ge(LiveCourseAccount::getLiveCourseId, liveCourse.getId()));
        }
        else
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "修改直播课程失败！" + msg);
        }
    }

    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return liveCourseConfigVo 直播配置信息
     */
    @Override
    public LiveCourseConfigVo getCourseConfig(Long id)
    {
        LiveCourseConfigVo liveCourseConfigVo = new LiveCourseConfigVo();

        // 根据课程 id 查询直播课程配置信息
        LiveCourseConfig liveCourseConfig = liveCourseConfigService.getLiveCourseConfigByLiveCourseId(id);

        if (liveCourseConfig != null)
        {
            // 查询直播课程商品列表
            List<LiveCourseGoods> liveCourseGoodsList = liveCourseGoodsService.getLiveCourseGoodsByLiveCourseId(id);

            // 封装 LiveCourseConfigVo
            BeanUtils.copyProperties(liveCourseConfig, liveCourseConfigVo);

            // 封装商品列表
            liveCourseConfigVo.setLiveCourseGoodsList(liveCourseGoodsList);
        }

        return liveCourseConfigVo;
    }

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateCourseConfig(LiveCourseConfigVo liveCourseConfigVo)
    {
        // 1、修改直播配置表
        LiveCourseConfig liveCourseConfig = new LiveCourseConfig();
        BeanUtils.copyProperties(liveCourseConfigVo, liveCourseConfig);

        if (liveCourseConfigVo.getId() == null)
        {
            liveCourseConfigService.save(liveCourseConfig);
        }
        else
        {
            liveCourseConfigService.update(liveCourseConfig, new LambdaUpdateWrapper<LiveCourseConfig>().eq(LiveCourseConfig::getLiveCourseId, liveCourseConfigVo.getLiveCourseId()));
        }

        // 2、修改直播商品表
        // 根据课程 id 批量删除直播商品列表
        liveCourseGoodsService.remove(new LambdaQueryWrapper<LiveCourseGoods>().eq(LiveCourseGoods::getLiveCourseId, liveCourseConfigVo.getLiveCourseId()));

        // 添加商品列表
        if (!CollectionUtils.isEmpty(liveCourseConfigVo.getLiveCourseGoodsList()))
        {
            liveCourseGoodsService.saveBatch(liveCourseConfigVo.getLiveCourseGoodsList());
        }

        // 3、修改在线直播平台中的直播配置信息
        this.updateLiveConfig(liveCourseConfigVo);
    }

    /**
     * 上传直播配置，修改在线直播平台中的直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    @SneakyThrows
    private void updateLiveConfig(LiveCourseConfigVo liveCourseConfigVo)
    {
        LiveCourse liveCourse = baseMapper.selectById(liveCourseConfigVo.getLiveCourseId());

        // 封装平台方法需要的参数
        // 参数设置
        HashMap<Object, Object> options = new HashMap<>();

        // 界面模式
        options.put("pageViewMode", liveCourseConfigVo.getPageViewMode());

        // 观看人数开关
        JSONObject number = new JSONObject();
        number.put("enable", liveCourseConfigVo.getNumberEnable());
        options.put("number", number.toJSONString());

        // 观看人数开关
        JSONObject store = new JSONObject();
        number.put("enable", liveCourseConfigVo.getStoreEnable());
        number.put("type", liveCourseConfigVo.getStoreType());
        options.put("store", number.toJSONString());

        // 商城列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();

        if (!CollectionUtils.isEmpty(liveCourseGoodsList))
        {
            List<LiveCourseGoodsView> liveCourseGoodsViewList = new ArrayList<>();

            for (LiveCourseGoods liveCourseGoods : liveCourseGoodsList)
            {
                LiveCourseGoodsView liveCourseGoodsView = new LiveCourseGoodsView();
                BeanUtils.copyProperties(liveCourseGoods, liveCourseGoodsView);
                liveCourseGoodsViewList.add(liveCourseGoodsView);
            }

            JSONObject goodsListEdit = new JSONObject();
            goodsListEdit.put("status", "0");
            options.put("goodsListEdit ", goodsListEdit.toJSONString());
            options.put("goodsList", JSON.toJSONString(liveCourseGoodsViewList));
        }

        String res = mtCloudClient.courseUpdateConfig(liveCourse.getCourseId().toString(), options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS)
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "修改配置信息失败！" + msg);
        }
    }

    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    @Override
    public List<LiveCourseVo> getLatelyList()
    {
        List<LiveCourseVo> liveCourseVoList = baseMapper.findLatelyList();

        for (LiveCourseVo liveCourseVo : liveCourseVoList)
        {
            // 封装开始和结束时间
            liveCourseVo.setStartTimeString(new DateTime(liveCourseVo.getStartTime()).toString("yyyy年MM月dd HH:mm:ss"));
            liveCourseVo.setEndTimeString(new DateTime(liveCourseVo.getEndTime()).toString("yyyy年MM月dd HH:mm:ss"));

            // 封装教师
            Long teacherId = liveCourseVo.getTeacherId();
            Teacher teacher = teacherFeignClient.getTeacherLive(teacherId);
            liveCourseVo.setTeacher(teacher);

            // 封装直播状态
            liveCourseVo.setLiveStatus(this.getLiveStatus(liveCourseVo));
        }

        return liveCourseVoList;
    }

    /**
     * 直播状态，0：未开始，1：直播中，2：直播结束
     *
     * @param liveCourse 直播课程
     * @return liveStatus 直播状态
     */
    private int getLiveStatus(LiveCourse liveCourse)
    {
        // 直播状态，0：未开始，1：直播中，2：直播结束
        int liveStatus;
        Date curTime = new Date();

        if (DateUtil.dateCompare(curTime, liveCourse.getStartTime()))
        {
            liveStatus = 0;
        }
        else if (DateUtil.dateCompare(curTime, liveCourse.getEndTime()))
        {
            liveStatus = 1;
        }
        else
        {
            liveStatus = 2;
        }

        return liveStatus;
    }

    /**
     * 获取用户 access_token
     *
     * @param id     id 直播课程 id
     * @param userId 用户 id
     * @return accessToken 访问令牌
     */
    @SneakyThrows
    @Override
    public JSONObject getAccessToken(Long id, Long userId)
    {
        // 根据课程 id 获取直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        // 根据用户 id 获取用户信息
        UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

        // 封装需要的参数
        HashMap<Object, Object> options = new HashMap<>();
        String res = mtCloudClient.courseAccess(liveCourse.getCourseId().toString(),
                userId.toString(),
                userInfo.getNickName(),
                MTCloud.ROLE_USER,
                80 * 80 * 80,
                options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            JSONObject accessToken = commonResult.getData();
            System.out.println("access_token = " + accessToken.getString("access_token"));

            return accessToken;
        }
        else
        {
            throw new SmartPlanetException(20001, "获取失败");
        }
    }

    /**
     * 根据直播课程 id 查询直播课程信息
     *
     * @param liveCourseId 直播课程 id
     * @return liveCourseInfo 直播课程信息
     */
    @Override
    public Map<String, Object> getInfoById(Long liveCourseId)
    {
        LiveCourse liveCourse = this.getById(liveCourseId);
        liveCourse.getParam().put("startTimeString", new DateTime(liveCourse.getStartTime()).toString("yyyy年MM月dd HH:mm"));
        liveCourse.getParam().put("endTimeString", new DateTime(liveCourse.getEndTime()).toString("yyyy年MM月dd HH:mm"));
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourse.getTeacherId());
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(liveCourseId);
        Map<String, Object> liveCourseInfo = new HashMap<>();
        liveCourseInfo.put("liveCourse", liveCourse);
        liveCourseInfo.put("liveStatus", this.getLiveStatus(liveCourse));
        liveCourseInfo.put("teacher", teacher);

        if (liveCourseDescription != null)
        {
            liveCourseInfo.put("description", liveCourseDescription.getDescription());
        }
        else
        {
            liveCourseInfo.put("description", "");
        }

        return liveCourseInfo;
    }
}
