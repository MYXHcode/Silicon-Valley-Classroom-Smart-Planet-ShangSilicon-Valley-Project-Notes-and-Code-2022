package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseAccountMapper;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程账号（受保护信息） 服务实现类
 * </p>
 */
@Service
public class LiveCourseAccountServiceImpl extends ServiceImpl<LiveCourseAccountMapper, LiveCourseAccount> implements LiveCourseAccountService
{
    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return liveCourseAccount 直播账号信息
     */
    @Override
    public LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseAccount> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseAccount::getLiveCourseId, id);
        LiveCourseAccount liveCourseAccount = baseMapper.selectOne(wrapper);

        return liveCourseAccount;
    }
}
