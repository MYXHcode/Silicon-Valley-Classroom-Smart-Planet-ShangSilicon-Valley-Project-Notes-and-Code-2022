package com.myxh.smart.planet.user.config;

import com.myxh.smart.planet.user.utils.ConstantPropertiesUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/18
 */
@Component
public class WeChatMpConfig
{
    @Autowired
    public WeChatMpConfig(ConstantPropertiesUtil constantPropertiesUtil)
    {

    }

    @Bean
    public WxMpService wxMpService(WxMpConfigStorage wxMpConfigStorage)
    {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage()
    {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        wxMpConfigStorage.setSecret(ConstantPropertiesUtil.ACCESS_KEY_SECRET);

        return wxMpConfigStorage;
    }
}
