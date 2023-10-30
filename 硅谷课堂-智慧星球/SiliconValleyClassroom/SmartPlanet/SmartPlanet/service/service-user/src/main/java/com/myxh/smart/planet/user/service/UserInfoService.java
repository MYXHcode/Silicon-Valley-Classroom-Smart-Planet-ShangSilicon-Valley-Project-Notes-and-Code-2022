package com.myxh.smart.planet.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.user.UserInfo;

;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 用户信息 服务类
 * </p>
 */
public interface UserInfoService extends IService<UserInfo>
{
    /**
     * 根据 openId 获取用户信息
     *
     * @param openId openId openId
     * @return userInfo 用户信息
     */
    UserInfo getUserInfoByOpenid(String openId);
}
