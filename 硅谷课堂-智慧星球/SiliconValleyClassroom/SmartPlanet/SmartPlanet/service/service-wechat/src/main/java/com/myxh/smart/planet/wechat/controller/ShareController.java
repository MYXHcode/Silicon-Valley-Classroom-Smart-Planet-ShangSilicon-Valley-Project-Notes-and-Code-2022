package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.order.Base64Util;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.wechat.WeChatJsapiSignatureVo;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/28
 */
@RestController
@RequestMapping("/api/wechat/share")
@Slf4j
public class ShareController
{
    @Autowired
    private WxMpService wxMpService;

    /**
     *  获取签名
     *
     * @param url url
     * @return Result 全局统一返回结果
     * @throws WxErrorException 微信错误异常
     */
    @GetMapping("/get/signature")
    public Result<WeChatJsapiSignatureVo> getSignature(@RequestParam("url") String url) throws WxErrorException
    {
        String currentUrl = url.replace("smartplanet", "#");
        WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature(currentUrl);
        WeChatJsapiSignatureVo wxJsapiSignatureVo = new WeChatJsapiSignatureVo();
        BeanUtils.copyProperties(jsapiSignature, wxJsapiSignatureVo);
        wxJsapiSignatureVo.setUserEedId(Base64Util.base64Encode(AuthContextHolder.getUserId() + ""));

        return Result.ok(wxJsapiSignatureVo);
    }
}
