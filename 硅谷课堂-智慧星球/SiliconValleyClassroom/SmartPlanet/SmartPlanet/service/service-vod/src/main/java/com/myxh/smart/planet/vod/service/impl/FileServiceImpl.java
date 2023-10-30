package com.myxh.smart.planet.vod.service.impl;

import com.myxh.smart.planet.vod.service.FileService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author MYXH
 * @date 2023/10/5
 */
@Service
public class FileServiceImpl implements FileService
{
    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    @Override
    public String upload(MultipartFile file)
    {
        // 1、初始化用户身份信息（secretId, secretKey）
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        // 用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretId = ConstantPropertiesUtil.ACCESS_KEY_ID;

        // 用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2、设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分
        Region region = new Region(ConstantPropertiesUtil.END_POINT);
        ClientConfig clientConfig = new ClientConfig(region);

        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 3、生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        try
        {
            // 4、上传文件
            // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
            String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

            // 对象键(Key)是对象在存储桶中的唯一标识
            // 在文件名称前面添加 uuid 值
            String key = UUID.randomUUID().toString().replaceAll("-", "")
                    + file.getOriginalFilename();

            // 在文件名称前面添加日期时间格式文件夹
            String dateTime = new DateTime().toString("yyyy/MM/dd");
            key = "ProductionCOS/image/" + dateTime + "/" + key;

            System.out.println("key = " + key);

            // 获取上传文件的输入流
            InputStream inputStream = file.getInputStream();

            ObjectMetadata objectMetadata = new ObjectMetadata();

            // 指定文件上传到 COS 上的路径，即对象键
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);

            // 执行文件上传
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            // 返回上传文件路径
            String url = "https://" + bucketName + "." + "cos" + "." + ConstantPropertiesUtil.END_POINT + ".myqcloud.com" + "/" + key;

            return url;

        }
        catch (CosClientException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return null;
    }
}
