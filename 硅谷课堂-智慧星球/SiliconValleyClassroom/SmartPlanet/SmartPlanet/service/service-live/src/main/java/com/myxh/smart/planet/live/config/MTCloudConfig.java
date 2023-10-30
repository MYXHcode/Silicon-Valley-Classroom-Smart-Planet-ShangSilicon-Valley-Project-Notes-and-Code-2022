package com.myxh.smart.planet.live.config;

import com.myxh.smart.planet.live.mtcloud.MTCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/26
 */
@Component
public class MTCloudConfig
{
    @Autowired
    private MTCloudAccountConfig mtCloudAccountConfig;

    @Bean
    public MTCloud mtCloudClient()
    {
        return new MTCloud(mtCloudAccountConfig.getOpenId(), mtCloudAccountConfig.getOpenToken());
    }
}
