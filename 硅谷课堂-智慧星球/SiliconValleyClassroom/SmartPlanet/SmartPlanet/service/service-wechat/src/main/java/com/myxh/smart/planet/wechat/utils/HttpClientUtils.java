package com.myxh.smart.planet.wechat.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author MYXH
 * @date 2023/10/17
 * @description 依赖的 jar 包有：commons-lang3.jar、httpclient.jar、httpcore.jar、commons-io.jar
 */
public class HttpClientUtils
{
    public static final int connTimeout = 10000;
    public static final int readTimeout = 10000;
    public static final String charset = "UTF-8";
    private static final HttpClient client;

    static
    {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(128);
        cm.setDefaultMaxPerRoute(128);
        client = HttpClients.custom().setConnectionManager(cm).build();
    }

    public static String postParameters(String url, String parameterStr) throws Exception
    {
        return post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
    }

    public static String postParameters(String url, String parameterStr, String charset, Integer connTimeout, Integer readTimeout) throws Exception
    {
        return post(url, parameterStr, "application/x-www-form-urlencoded", charset, connTimeout, readTimeout);
    }

    public static String postParameters(String url, Map<String, String> params) throws Exception
    {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static String postParameters(String url, Map<String, String> params, Integer connTimeout, Integer readTimeout) throws Exception
    {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static String get(String url) throws Exception
    {
        return get(url, charset, null, null);
    }

    public static String get(String url, String charset) throws Exception
    {
        return get(url, charset, connTimeout, readTimeout);
    }

    /**
     * 发送一个 Post 请求, 使用指定的字符集编码.
     *
     * @param url         url
     * @param body        RequestBody
     * @param mimeType    例如 application/xml "application/x-www-form-urlencoded" a=1&b=2&c=3
     * @param charset     编码
     * @param connTimeout 建立链接超时时间，毫秒
     * @param readTimeout 响应超时时间，毫秒
     * @return ResponseBody 使用指定的字符集编码
     * @throws Exception 异常
     */
    public static String post(String url, String body, String mimeType, String charset, Integer connTimeout, Integer readTimeout) throws Exception
    {
        HttpClient client = null;
        HttpPost post = new HttpPost(url);
        String result;

        try
        {
            if (StringUtils.isNotBlank(body))
            {
                HttpEntity entity = new StringEntity(body, ContentType.create(mimeType, charset));
                post.setEntity(entity);
            }

            // 设置参数
            Builder customReqConf = RequestConfig.custom();

            if (connTimeout != null)
            {
                customReqConf.setConnectTimeout(connTimeout);
            }

            if (readTimeout != null)
            {
                customReqConf.setSocketTimeout(readTimeout);
            }

            post.setConfig(customReqConf.build());
            HttpResponse res;

            if (url.startsWith("https"))
            {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
            }
            else
            {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
            }

            res = client.execute(post);
            result = IOUtils.toString(res.getEntity().getContent(), charset);
        }
        finally
        {
            post.releaseConnection();

            if (url.startsWith("https") && client instanceof CloseableHttpClient)
            {
                ((CloseableHttpClient) client).close();
            }
        }

        return result;
    }


    /**
     * 提交 form 表单
     *
     * @param url         url
     * @param params      RequestParams
     * @param connTimeout 建立链接超时时间，毫秒
     * @param readTimeout 响应超时时间，毫秒
     * @return ResponseBody 使用指定的字符集编码
     * @throws Exception 异常
     */
    public static String postForm(String url, Map<String, String> params, Map<String, String> headers, Integer connTimeout, Integer readTimeout) throws Exception
    {

        HttpClient client = null;
        HttpPost post = new HttpPost(url);

        try
        {
            if (params != null && !params.isEmpty())
            {
                List<NameValuePair> formParams = new ArrayList<>();
                Set<Entry<String, String>> entrySet = params.entrySet();

                for (Entry<String, String> entry : entrySet)
                {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }

                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
                post.setEntity(entity);
            }

            if (headers != null && !headers.isEmpty())
            {
                for (Entry<String, String> entry : headers.entrySet())
                {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }

            // 设置参数
            Builder customReqConf = RequestConfig.custom();

            if (connTimeout != null)
            {
                customReqConf.setConnectTimeout(connTimeout);
            }

            if (readTimeout != null)
            {
                customReqConf.setSocketTimeout(readTimeout);
            }

            post.setConfig(customReqConf.build());
            HttpResponse res;

            if (url.startsWith("https"))

            {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
            }
            else
            {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
            }

            res = client.execute(post);

            return IOUtils.toString(res.getEntity().getContent(), StandardCharsets.UTF_8);
        }
        finally
        {
            post.releaseConnection();

            if (url.startsWith("https") && client instanceof CloseableHttpClient)
            {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    /**
     * 发送一个 GET 请求
     *
     * @param url         url
     * @param charset     编码
     * @param connTimeout 建立链接超时时间，毫秒
     * @param readTimeout 响应超时时间，毫秒
     * @return ResponseBody 使用指定的字符集编码
     * @throws Exception 异常
     */
    public static String get(String url, String charset, Integer connTimeout, Integer readTimeout) throws Exception
    {

        HttpClient client = null;
        HttpGet get = new HttpGet(url);
        String result;

        try
        {
            // 设置参数
            Builder customReqConf = RequestConfig.custom();

            if (connTimeout != null)
            {
                customReqConf.setConnectTimeout(connTimeout);
            }

            if (readTimeout != null)
            {
                customReqConf.setSocketTimeout(readTimeout);
            }

            get.setConfig(customReqConf.build());
            HttpResponse res;

            if (url.startsWith("https"))
            {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
            }
            else
            {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
            }

            res = client.execute(get);
            result = IOUtils.toString(res.getEntity().getContent(), charset);
        }
        finally
        {
            get.releaseConnection();

            if (url.startsWith("https") && client instanceof CloseableHttpClient)
            {
                ((CloseableHttpClient) client).close();
            }
        }

        return result;
    }


    /**
     * 从 response 里获取 charset
     *
     * @param response 响应
     * @return ResponseBody 使用指定的字符集编码
     */
    @SuppressWarnings("unused")
    private static String getCharsetFromResponse(HttpResponse response)
    {
        // Content-Type:text/html; charset=GBK
        if (response.getEntity() != null && response.getEntity().getContentType() != null && response.getEntity().getContentType().getValue() != null)
        {
            String contentType = response.getEntity().getContentType().getValue();

            if (contentType.contains("charset="))
            {
                return contentType.substring(contentType.indexOf("charset=") + 8);
            }
        }

        return null;
    }


    /**
     * 创建 SSL连接
     *
     * @return ResponseBody 使用指定的字符集编码
     */
    private static CloseableHttpClient createSSLInsecureClient()
    {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager()
        {
            public java.security.cert.X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
            {

            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
            {

            }
        }};

        try
        {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        }
        catch (GeneralSecurityException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            String str = post("https://localhost:443/ssl/test.shtml", "name=12&page=34", "application/x-www-form-urlencoded", "UTF-8", 10000, 10000);
            // String str= get("https://localhost:443/ssl/test.shtml?name=12&page=34","GBK");
            /*
            Map<String,String> map = new HashMap<String,String>();
            map.put("name", "12");
            map.put("page", "34");
            String str= postForm("https://localhost:443/ssl/test.shtml",map,null, 10000, 10000);
             */

            System.out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
