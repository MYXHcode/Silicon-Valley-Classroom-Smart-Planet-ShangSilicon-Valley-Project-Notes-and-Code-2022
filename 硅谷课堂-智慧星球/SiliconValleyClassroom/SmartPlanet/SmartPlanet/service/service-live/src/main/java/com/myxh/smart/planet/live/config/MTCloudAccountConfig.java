package com.myxh.smart.planet.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/26
 */
@Data
@Component
@ConfigurationProperties(prefix = "mtcloud")
public class MTCloudAccountConfig
{
    private String openId;
    private String openToken;
}
