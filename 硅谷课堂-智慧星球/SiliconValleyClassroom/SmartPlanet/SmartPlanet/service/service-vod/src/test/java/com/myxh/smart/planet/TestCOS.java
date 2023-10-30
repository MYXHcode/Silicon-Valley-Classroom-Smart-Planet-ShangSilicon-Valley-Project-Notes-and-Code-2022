package com.myxh.smart.planet;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.ibatis.javassist.LoaderClassPath;

import java.io.File;
import java.net.URI;

/**
 * @author MYXH
 * @date 2023/10/5
 */
public class TestCOS
{
    public static void main(String[] args)
    {
        // 1、初始化用户身份信息（secretId, secretKey）
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        // 用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretId = "AKIDeOxIPH0VlnaBYgAQUKvIfqmUyFI7kAPS";

        // 用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = "wfFqEQPDpEQPDpEQYWHpBMNBmCRUKxVr";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2、设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);

        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 3、生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 4、测试上传
        try
        {
            // 指定要上传的文件
            URI uri = LoaderClassPath.class.getResource("/image/大户爱.png").toURI();
            File localFile = new File(uri);

            // 指定文件将要存放的存储桶
            String bucketName = "smart-planet-1315007088";

            // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
            String key = "TestCOS/image/大户爱.png";
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            System.out.println(JSON.toJSONString(putObjectResult));
        }
        catch (Exception clientException)
        {
            clientException.printStackTrace();
        }
    }
}
