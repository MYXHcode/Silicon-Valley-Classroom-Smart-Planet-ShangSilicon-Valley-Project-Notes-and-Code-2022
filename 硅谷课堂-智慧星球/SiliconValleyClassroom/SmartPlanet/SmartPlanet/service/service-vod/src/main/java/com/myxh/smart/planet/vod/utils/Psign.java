package com.myxh.smart.planet.vod.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class Psign
{
    public static String getPsign(Integer appId, String fileId)
    {
        // 点播应用 appId
        Integer AppId = appId;

        // 点播文件 ID
        String FileId = fileId;

        // 播放的音视频类型，可选值
        // RawAdaptive：未加密的，转自适应码流，输出。
        // ProtectedAdaptive：私有加密或 DRM 保护的，转自适应码流，输出
        // Transcode：转码后输出
        // Original：上传的原始音视频
        String AudioVideoType = "RawAdaptive";

        Integer RawAdaptiveDefinition = 10;
        Integer ImageSpriteDefinition = 10;

        // 派发签名当前 Unix 时间戳
        Integer CurrentTime = Math.toIntExact(System.currentTimeMillis() / 1000);

        // 播放密钥
        String PlayKey = "cw8EdW6d9indO6f3Uk6s";

        HashMap<String, Object> urlAccessInfo = new HashMap<>();

        HashMap<String, Object> contentInfo = new HashMap<>();
        contentInfo.put("audioVideoType", AudioVideoType);
        contentInfo.put("rawAdaptiveDefinition", RawAdaptiveDefinition);
        contentInfo.put("imageSpriteDefinition", ImageSpriteDefinition);


        Algorithm algorithm = Algorithm.HMAC256(PlayKey);

        String token = JWT.create()
                .withClaim("appId", AppId)
                .withClaim("fileId", FileId)
                .withClaim("contentInfo", contentInfo)
                .withClaim("currentTimeStamp", CurrentTime)
                .withClaim("urlAccessInfo", urlAccessInfo).sign(algorithm);

        return token;
    }
}
