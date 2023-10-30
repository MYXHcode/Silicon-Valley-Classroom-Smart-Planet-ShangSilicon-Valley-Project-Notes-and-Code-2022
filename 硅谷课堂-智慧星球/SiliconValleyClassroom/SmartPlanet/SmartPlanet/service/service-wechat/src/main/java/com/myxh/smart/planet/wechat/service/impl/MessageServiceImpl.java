package com.myxh.smart.planet.wechat.service.impl;

import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.wechat.service.MessageService;
import lombok.SneakyThrows;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private WxMpService wxMpService;

    /**
     * 接收微信服务器发送来的消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    @Override
    public String receiveMessage(Map<String, String> param)
    {
        String content;

        try
        {
            String msgType = param.get("MsgType");

            // 判断是什么类型消息
            switch (msgType)
            {
                // 普通文本类型，输入关键字 Java
                case "text":
                    content = this.search(param);
                    break;
                // 事件类型
                case "event":
                    String event = param.get("Event");
                    String eventKey = param.get("EventKey");

                    if ("subscribe".equals(event))
                    {
                        // 关注公众号
                        content = this.subscribe(param);
                    }
                    else if ("unsubscribe".equals(event))
                    {
                        // 取消关注公众号
                        content = this.unsubscribe(param);
                    }
                    else if ("CLICK".equals(event) && "aboutUs".equals(eventKey))
                    {
                        // 关于我们
                        content = this.aboutUs(param);
                    }
                    else
                    {
                        content = "success";
                    }
                    break;
                default:
                    // 其他情况
                    content = "success";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            content = this.text(param, "请重新输入关键字，没有匹配到相关视频课程").toString();
        }

        return content;
    }

    /**
     * 处理关键字搜索事件
     * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复 1 条图文消息；其余场景最多可回复 8 条图文消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String search(Map<String, String> param)
    {
        String fromUsername = param.get("FromUserName");
        String toUsername = param.get("ToUserName");
        String content = param.get("Content");

        // 单位为秒，不是毫秒
        long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();
        List<Course> courseList = courseFeignClient.findByKeyword(content);

        if (CollectionUtils.isEmpty(courseList))
        {
            text = this.text(param, "请重新输入关键字，没有匹配到相关视频课程");
        }
        else
        {
            // 一次只能返回一个
            Random random = new Random();
            int num = random.nextInt(courseList.size());
            Course course = courseList.get(num);

            String articles = "<item>" +
                    "<Title><![CDATA[" + course.getTitle() + "]]></Title>" +
                    "<Description><![CDATA[" + course.getTitle() + "]]></Description>" +
                    "<PicUrl><![CDATA[" + course.getCover() + "]]></PicUrl>" +
                    "<Url><![CDATA[http://smartplanetmobile.free.idcfengye.com/#/live/info/" + course.getId() + "]]></Url>" +
                    "</item>";

            text.append("<xml>");
            text.append("<ToUserName><![CDATA[").append(fromUsername).append("]]></ToUserName>");
            text.append("<FromUserName><![CDATA[").append(toUsername).append("]]></FromUserName>");
            text.append("<CreateTime><![CDATA[").append(createTime).append("]]></CreateTime>");
            text.append("<MsgType><![CDATA[news]]></MsgType>");
            text.append("<ArticleCount><![CDATA[1]]></ArticleCount>");
            text.append("<Articles>");
            text.append(articles);
            text.append("</Articles>");
            text.append("</xml>");
        }

        return text.toString();
    }

    /**
     * 回复文本
     *
     * @param param   请求参数
     * @param content 上下文
     * @return message 消息
     */
    private StringBuffer text(Map<String, String> param, String content)
    {
        String fromUsername = param.get("FromUserName");
        String toUsername = param.get("ToUserName");

        // 单位为秒，不是毫秒
        long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();

        text.append("<xml>");
        text.append("<ToUserName><![CDATA[").append(fromUsername).append("]]></ToUserName>");
        text.append("<FromUserName><![CDATA[").append(toUsername).append("]]></FromUserName>");
        text.append("<CreateTime><![CDATA[").append(createTime).append("]]></CreateTime>");
        text.append("<MsgType><![CDATA[text]]></MsgType>");
        text.append("<Content><![CDATA[").append(content).append("]]></Content>");
        text.append("</xml>");

        return text;
    }

    /**
     * 处理关注事件
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String subscribe(Map<String, String> param)
    {
        return this.text(param, "感谢你关注“智慧星球”，可以根据关键字搜索你想看的视频教程，如：Java 基础、Spring Boot、大数据等。").toString();
    }

    /**
     * 处理取消关注事件
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String unsubscribe(Map<String, String> param)
    {
        return "success";
    }

    /**
     * 关于我们
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String aboutUs(Map<String, String> param)
    {
        StringBuffer message = this.text(param, "智慧星球现开设 Java、HTML5 前端 + 全栈、大数据、全链路 UI/UE 设计、人工智能、大数据运维 + Python 自动化、Android + HTML5 混合开发等多门课程；" +
                "同时，通过视频分享、智慧星球在线课堂、大厂学苑直播课堂等多种方式，满足了全国编程爱好者对多样化学习场景的需求，已经为行业输送了大量 IT 技术人才。");

        return message.toString();
    }

    /**
     * 推送支付消息，订单成功
     * 暂时写成固定值测试，后续完善
     */
    @SneakyThrows
    @Override
    public void pushPayMessage(long orderId)
    {
        // 微信 openid
        String openid = "oxM4d64iKq9SD6lduBKcF4MQTjF8";
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // 要推送的用户 openid
                .toUser(openid)
                // 模板 id
                .templateId("URQAUtz9-IrYVFwsuI5Ul4pKUcRFKGmOTwRAb6lscJM")
                // 点击模板消息要访问的网址
                .url("http://smartplanet.free.idcfengye.com/#/pay/" + orderId)
                .build();

        // 如果是正式版发送消息，这里需要配置信息
        templateMessage.addData(new WxMpTemplateData("first", "亲爱的用户：您有一笔订单支付成功。", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "20231123180908744", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "Java基础课程", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "2023-11-23", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword4", "100", "#272727"));
        templateMessage.addData(new WxMpTemplateData("remark", "感谢你购买课程，如有疑问，随时咨询！", "#272727"));
        String message = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        System.out.println(message);
    }
}
