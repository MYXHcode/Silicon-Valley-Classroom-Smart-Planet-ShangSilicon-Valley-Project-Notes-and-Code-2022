package com.myxh.smart.planet.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/10/19
 */
public class JwtHelper
{
    // token 字符串有效时间
    private static final long tokenExpiration = 24 * 60 * 60 * 1000;

    // 加密编码秘钥
    private static final String tokenSignKey = "SmartPlanetSmartPlanetSmartPlanetSmartPlanetSmartPlanetSmartPlanet";

    /**
     * 根据 userId 和 username 生成 token 字符串
     *
     * @param userId   用户 id
     * @param userName 用户姓名
     * @return token 字符串
     */
    public static String createToken(Long userId, String userName)
    {
        String token = Jwts.builder()
                // 设置 token 分类
                .setSubject("SmartPlanet-USER")

                // token 字符串有效时长
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))

                // 私有部分（用户信息）
                .claim("userId", userId)
                .claim("userName", userName)

                // 根据秘钥使用加密编码方式进行加密，对字符串压缩
                .signWith(Keys.hmacShaKeyFor(tokenSignKey.getBytes()), SignatureAlgorithm.HS512)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    /**
     * 从 token字符串获取 userId
     *
     * @param token token字符串
     * @return 用户 id
     */
    public static Long getUserId(String token)
    {
        if (ObjectUtils.isEmpty(token))
        {
            return null;
        }

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(tokenSignKey.getBytes()).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");

        return userId.longValue();
    }

    /**
     * 从 token 字符串获取 userName
     *
     * @param token token字符串
     * @return userName 用户姓名
     */
    public static String getUserName(String token)
    {
        if (ObjectUtils.isEmpty(token))
        {
            return "";
        }

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(tokenSignKey.getBytes()).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String userName = (String) claims.get("userName");

        return userName;
    }

    public static void main(String[] args)
    {
        String token = JwtHelper.createToken(1L, "MYXH");
        System.out.println("token = " + token);
        System.out.println("JwtHelper.getUserId(token) = " + JwtHelper.getUserId(token));
        System.out.println("JwtHelper.getUserName(token) = " + JwtHelper.getUserName(token));
    }
}
