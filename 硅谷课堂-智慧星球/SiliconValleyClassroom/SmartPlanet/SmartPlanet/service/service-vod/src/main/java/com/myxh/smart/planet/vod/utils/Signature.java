package com.myxh.smart.planet.vod.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author MYXH
 * @date 2023/10/11
 * @description 签名工具类
 */
public class Signature
{
    private String secretId;
    private String secretKey;
    private long currentTime;
    private int random;
    private int signValidDuration;

    private String procedure;

    // 签名算法
    private static final String HMAC_ALGORITHM = "HmacSHA1";
    private static final String CONTENT_CHARSET = "UTF-8";

    public static byte[] byteMerger(byte[] byte1, byte[] byte2)
    {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);

        return byte3;
    }

    // 获取签名
    public String getUploadSignature() throws Exception
    {
        String strSign = "";
        String contextStr = "";

        // 生成原始参数字符串
        long endTime = (currentTime + signValidDuration);
        contextStr += "secretId=" + java.net.URLEncoder.encode(secretId, StandardCharsets.UTF_8);
        contextStr += "&currentTimeStamp=" + currentTime;
        contextStr += "&expireTime=" + endTime;
        contextStr += "&random=" + random;

        // 设置转码任务流
        contextStr += "&procedure=" + procedure;

        try
        {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(this.secretKey.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
            mac.init(secretKey);

            byte[] hash = mac.doFinal(contextStr.getBytes(CONTENT_CHARSET));
            byte[] sigBuf = byteMerger(hash, contextStr.getBytes(StandardCharsets.UTF_8));
            strSign = base64Encode(sigBuf);
            strSign = strSign.replace(" ", "").replace("\n", "").replace("\r", "");
        }
        catch (Exception e)
        {
            throw e;
        }
        return strSign;
    }

    private String base64Encode(byte[] buffer)
    {
        Base64.Encoder encoder = Base64.getEncoder();

        return encoder.encodeToString(buffer);
    }

    public void setSecretId(String secretId)
    {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public void setCurrentTime(long currentTime)
    {
        this.currentTime = currentTime;
    }

    public void setRandom(int random)
    {
        this.random = random;
    }

    public void setSignValidDuration(int signValidDuration)
    {
        this.signValidDuration = signValidDuration;
    }

    public void setProcedure(String procedure)
    {
        this.procedure = procedure;
    }
}
