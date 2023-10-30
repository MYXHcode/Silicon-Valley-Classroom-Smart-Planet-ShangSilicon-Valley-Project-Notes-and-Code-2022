package com.myxh.smart.planet.user.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "微信用户 API（测试微信支付功能）", description = "微信用户 API 接口（测试微信支付功能）")
@Controller
@RequestMapping("/api/user/openid")
public class GetOpenIdController
{
    @Autowired
    private WxMpService wxMpService;

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
        String userInfoUrl = "http://smartplanet.free.idcfengye.com/api/user/openid/user/info";
        String redirectURL = wxMpService
                .getOAuth2Service().buildAuthorizationUrl(userInfoUrl,
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
    @ResponseBody
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl)
    {
        try
        {
            // 拿着 code 发送请求
            WxOAuth2AccessToken wxOAuth2AccessToken = null;

            wxOAuth2AccessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);


            // 获取 openId
            String openId = wxOAuth2AccessToken.getOpenId();
            System.out.println("正式服务公众号微信网页授权 openId = " + openId);

            return openId;
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
