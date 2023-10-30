package com.myxh.smart.planet.order;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Pattern;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class Base64Util
{
    /**
     * 使用 Base64 进行加密
     *
     * @param content 密文
     * @return base64Encode base64 编码
     */
    @SneakyThrows
    public static String base64Encode(String content)
    {
        String base64Encode = Base64.getEncoder().encodeToString(content.getBytes(StandardCharsets.UTF_8));

        return base64Encode;
    }

    /**
     * 使用 Base64 进行解密
     *
     * @param content 密文
     * @return base64Decode base64 解码
     */
    @SneakyThrows
    public static String base64Decode(String content)
    {
        String base64Decode = new String(Base64.getDecoder().decode(content), StandardCharsets.UTF_8);

        return base64Decode;
    }

    public static boolean isNumeric(String str)
    {
        Pattern pattern = Pattern.compile("^[1-9][0-9]*$");

        return pattern.matcher(str).matches();
    }

    public static void main(String[] args)
    {
        System.out.println(UrlUtil.getParam("http://smartplanet.free.idcfengye.com/#/live/info/7?recommend=MQ==", "recommend"));
        System.out.println(Base64Util.base64Encode("q2"));
        System.out.println(Base64Util.base64Decode("MQ=="));
    }
}
