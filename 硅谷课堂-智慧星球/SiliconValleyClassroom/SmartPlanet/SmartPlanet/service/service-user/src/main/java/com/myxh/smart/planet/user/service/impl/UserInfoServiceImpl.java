package com.myxh.smart.planet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.mapper.UserInfoMapper;
import com.myxh.smart.planet.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 用户信息 服务实现类
 * </p>
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService
{
    /**
     * 根据 openId 获取用户信息
     *
     * @param openId openId openId
     * @return userInfo 用户信息
     */
    @Override
    public UserInfo getUserInfoByOpenid(String openId)
    {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id", openId);
        UserInfo userInfo = baseMapper.selectOne(wrapper);

        return userInfo;
    }
}
