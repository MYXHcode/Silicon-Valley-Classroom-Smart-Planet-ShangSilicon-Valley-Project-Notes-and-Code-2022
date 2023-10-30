package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseAccount;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程账号（受保护信息） 服务类
 * </p>
 */
public interface LiveCourseAccountService extends IService<LiveCourseAccount>
{
    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return liveCourseAccount 直播账号信息
     */
    LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id);
}
