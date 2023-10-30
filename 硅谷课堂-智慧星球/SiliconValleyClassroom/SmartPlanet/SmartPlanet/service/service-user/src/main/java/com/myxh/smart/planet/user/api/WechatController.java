package com.myxh.smart.planet.user.api;

import com.alibaba.fastjson2.JSON;
import com.myxh.smart.planet.jwt.JwtHelper;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.service.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/10/18
 */
@Tag(name = "微信用户 API", description = "微信用户 API 接口")
@Controller
@RequestMapping("/api/user/wechat")
public class WechatController
{
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WxMpService wxMpService;

    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;

    /**
     * 授权跳转
     *
     * @param returnUrl 返回 url
     * @param request   请求
     * @return redirectURL 重定向 url
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl, HttpServletRequest request)
    {
        String redirectURL = wxMpService.getOAuth2Service().buildAuthorizationUrl(userInfoUrl,
                WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                URLEncoder.encode(returnUrl.replace("#", "smartplanet"), StandardCharsets.UTF_8));

        return "redirect:" + redirectURL;
    }

    /**
     * 获取用户信息
     *
     * @param code      密码
     * @param returnUrl 返回 url
     * @return redirectURL 重定向 url
     */
    @GetMapping("/user/info")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl)
    {
        try
        {
            // 拿着 code 发送请求
            WxOAuth2AccessToken wxOAuth2AccessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);

            // 获取 openId
            String openId = wxOAuth2AccessToken.getOpenId();
            System.out.println("微信网页授权 openId = " + openId);

            // 获取微信信息
            WxOAuth2UserInfo wxOAuth2UserInfo = wxMpService.getOAuth2Service().getUserInfo(wxOAuth2AccessToken, null);
            System.out.println("微信网页授权 wxOAuth2UserInfo = " + JSON.toJSONString(wxOAuth2UserInfo));

            // 获取微信信息添加到数据库
            UserInfo userInfo = userInfoService.getUserInfoByOpenid(openId);

            if (userInfo == null)
            {
                userInfo = new UserInfo();
                userInfo.setOpenId(openId);
                userInfo.setUnionId(wxOAuth2UserInfo.getUnionId());
                userInfo.setNickName(wxOAuth2UserInfo.getNickname());
                userInfo.setAvatar(wxOAuth2UserInfo.getHeadImgUrl());
                userInfo.setSex(wxOAuth2UserInfo.getSex());
                userInfo.setProvince(wxOAuth2UserInfo.getProvince());
                userInfoService.save(userInfo);
            }

            // 生成 token，按照一定规则生成字符串，可以包含用户信息
            String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());

            // 授权完成之后，跳转具体功能页面
            if (!returnUrl.contains("?"))
            {
                return "redirect:" + returnUrl + "?token=" + token;
            }
            else
            {
                return "redirect:" + returnUrl + "&token=" + token;
            }
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
