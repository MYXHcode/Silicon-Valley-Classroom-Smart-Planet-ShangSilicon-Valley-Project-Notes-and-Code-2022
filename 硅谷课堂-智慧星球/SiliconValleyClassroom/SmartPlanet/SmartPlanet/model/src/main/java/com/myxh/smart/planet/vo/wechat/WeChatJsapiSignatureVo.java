package com.myxh.smart.planet.vo.wechat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Schema(description = "分享签名对象")
@Data
public class WeChatJsapiSignatureVo
{
    private String appId;
    private String nonceStr;
    private long timestamp;
    private String url;
    private String signature;

    // 加密用户ID
    private String userEedId;
}
