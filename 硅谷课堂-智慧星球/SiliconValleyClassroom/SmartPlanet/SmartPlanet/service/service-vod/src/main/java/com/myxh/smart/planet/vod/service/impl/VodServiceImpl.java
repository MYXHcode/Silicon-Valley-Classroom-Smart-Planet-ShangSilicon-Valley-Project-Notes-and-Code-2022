package com.myxh.smart.planet.vod.service.impl;

import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vod.service.VideoService;
import com.myxh.smart.planet.vod.service.VodService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.myxh.smart.planet.vod.utils.Psign;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.apache.ibatis.javassist.LoaderClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Service
public class VodServiceImpl implements VodService
{
    // @Lazy 注解可以延迟 Bean 的初始化，缓解循环引用
    @Lazy
    @Autowired
    private VideoService videoService;

    @Value("${tencent.video.appid}")
    private String appId;

    /**
     * 上传视频
     *
     * @param inputStream      输入流
     * @param originalFilename 原始文件名
     * @return videoId 视频 id
     */
    @Override
    public String uploadVideo(InputStream inputStream, String originalFilename)
    {
        try
        {
            // 指定当前腾讯云账号 id 和 密码
            VodUploadClient client = new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 视频上传请求对象
            VodUploadRequest request = new VodUploadRequest();

            // 指定要上传的文件
            String path = LoaderClassPath.class.getResource("/video/Java 零基础入门.mp4").getPath();

            // 设置视频文件的本地路径
            request.setMediaFilePath(path);

            // 指定任务流
            request.setProcedure("LongVideoPreset");

            // 调用上传方法，传入接入点地域及上传请求
            VodUploadResponse response = client.upload("ap-beijing", request);

            // 返回文件 id 保存到业务表，用于控制视频播放
            String fileId = response.getFileId();
            System.out.println("fileId = " + fileId);

            return fileId;
        }
        catch (Exception e)
        {
            throw new SmartPlanetException(20001, "上传视频失败");
        }
    }

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     */
    @Override
    public void removeVideo(String videoSourceId)
    {
        try
        {
            // 实例化一个认证对象，入参需要传入腾讯云账户 secretId，secretKey
            Credential cred = new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 实例化要请求产品的 client 对象，clientProfile 是可选的
            VodClient client = new VodClient(cred, "ap-beijing");

            // 实例化一个请求对象，每个接口都会对应一个 request 对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId(videoSourceId);

            // 返回的 resp 是一个 DeleteMediaResponse 的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);

            // 输出 json 格式的字符串回包
            System.out.println("DeleteMediaResponse.toJsonString(resp) = " + DeleteMediaResponse.toJsonString(resp));
        }
        catch (TencentCloudSDKException e)
        {
            throw new SmartPlanetException(20001, "删除视频失败");

        }
    }

    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return playAuthMap 播放凭证
     */
    @Override
    public Map<String, Object> getPlayAuth(Long courseId, Long videoId)
    {
        // 根据小节 id 获取小节对象，获取腾讯云视频 id
        Video video = videoService.getById(videoId);

        if(video == null) {
            throw new SmartPlanetException(20001,"课程视频信息不存在");
        }

        String videoSourceId = video.getVideoSourceId();
        Integer id= Integer.valueOf(appId);
        String psign = Psign.getPsign(id,videoSourceId);

        Map<String, Object> playAuthMap = new HashMap<>();
        playAuthMap.put("videoSourceId",videoSourceId);
        playAuthMap.put("appId",appId);
        playAuthMap.put("psign", psign);

        return playAuthMap;
    }
}
