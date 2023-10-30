package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.wechat.service.MessageService;
import com.myxh.smart.planet.wechat.utils.SHA1;
import jakarta.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController
{
    private static final String token = "SmartPlanet";

    @Autowired
    private MessageService messageService;

    /**
     * 服务器有效性验证
     *
     * @param request 请求
     * @return echostr 随机字符串
     */
    @GetMapping
    public String verifyToken(HttpServletRequest request)
    {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        System.out.println("signature: " + signature + " nonce: " + nonce + " echostr: " + echostr + "timestamp: " + timestamp);

        if (this.checkSignature(signature, timestamp, nonce))
        {
            System.out.println("token ok");

            return echostr;
        }

        return echostr;
    }

    private boolean checkSignature(String signature, String timestamp, String nonce)
    {
        String[] str = new String[]{token, timestamp, nonce};

        // 排序
        Arrays.sort(str);

        // 拼接字符串
        StringBuilder buffer = new StringBuilder();

        for (String s : str)
        {
            buffer.append(s);
        }

        // 进行 SHA1 加密
        String temp = SHA1.encode(buffer.toString());

        // 与微信提供的 signature 进行匹对
        return signature.equals(temp);
    }

    /**
     * 接收微信服务器发送来的消息
     *
     * @param request 请求
     * @return message 消息
     * @throws Exception 异常
     */
    @PostMapping
    public String receiveMessage(HttpServletRequest request) throws Exception
    {
        /*
        WxMpXmlMessage wxMpXmlMessage = WxMpXmlMessage.fromXml(request.getInputStream());
        System.out.println(JSONObject.toJSONString(wxMpXmlMessage));

        return "success";
         */

        Map<String, String> param = this.parseXml(request);
        String message = messageService.receiveMessage(param);

        return message;
    }

    private Map<String, String> parseXml(HttpServletRequest request) throws Exception
    {
        Map<String, String> map = new HashMap<>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();

        for (Element e : elementList)
        {
            map.put(e.getName(), e.getText());
        }

        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 推送支付消息
     *
     * @return Result 全局统一返回结果
     */
    @GetMapping("/push/pay/message")
    public Result<Void> pushPayMessage()
    {
        messageService.pushPayMessage(1L);

        return Result.ok(null);
    }
}
