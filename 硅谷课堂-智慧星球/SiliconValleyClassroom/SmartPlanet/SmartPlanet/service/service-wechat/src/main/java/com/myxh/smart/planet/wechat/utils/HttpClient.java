package com.myxh.smart.planet.wechat.utils;

import lombok.Getter;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 * @description http 请求客户端
 */
public class HttpClient
{
    private String url;
    private Map<String, String> param;

    @Getter
    private int statusCode;

    @Getter
    private String content;

    @Getter
    private String xmlParam;

    private boolean isHttps;
    private boolean isCert = false;

    // 证书密码 微信商户号（mch_id）
    @Getter
    private String certPassword;

    public HttpClient(String url)
    {
        this.url = url;
    }

    public HttpClient(String url, Map<String, String> param)
    {
        this.url = url;
        this.param = param;
    }

    public void setParameter(Map<String, String> map)
    {
        param = map;
    }

    public void setXmlParam(String xmlParam)
    {
        this.xmlParam = xmlParam;
    }

    public boolean isHttps()
    {
        return isHttps;
    }

    public void setHttps(boolean isHttps)
    {
        this.isHttps = isHttps;
    }

    public boolean isCert()
    {
        return isCert;
    }

    public void setCert(boolean cert)
    {
        isCert = cert;
    }

    public void setCertPassword(String certPassword)
    {
        this.certPassword = certPassword;
    }

    public void addParameter(String key, String value)
    {
        if (param == null)
        {
            param = new HashMap<>();
        }

        param.put(key, value);
    }

    public void post() throws IOException
    {
        HttpPost http = new HttpPost(url);
        setEntity(http);
        execute(http);
    }

    public void put() throws IOException
    {
        HttpPut http = new HttpPut(url);
        setEntity(http);
        execute(http);
    }

    public void get() throws IOException
    {
        if (param != null)
        {
            StringBuilder url = new StringBuilder(this.url);

            for (String key : param.keySet())
            {
                url.append("?");
                url.append(key).append("=").append(param.get(key));
            }

            this.url = url.toString();
        }

        HttpGet http = new HttpGet(url);
        execute(http);
    }

    /**
     * 设置 http post，放置 param
     *
     * @param http http
     */
    private void setEntity(HttpEntityEnclosingRequestBase http)
    {
        if (param != null)
        {
            List<NameValuePair> nvps = new LinkedList<>();

            for (String key : param.keySet())
            {
                // 参数
                nvps.add(new BasicNameValuePair(key, param.get(key)));
            }

            // 设置参数
            http.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        }

        if (xmlParam != null)
        {
            http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
        }
    }

    private void execute(HttpUriRequest http) throws IOException
    {
        CloseableHttpClient httpClient = null;

        try
        {
            if (isHttps)
            {
                if (isCert)
                {
                    // 退款使用，需要完善
                    FileInputStream inputStream = null;
                    // FileInputStream inputStream = new FileInputStream(new File(ConstantPropertiesUtil.CERT));
                    KeyStore keystore = KeyStore.getInstance("PKCS12");
                    char[] partnerId2charArray = certPassword.toCharArray();
                    keystore.load(inputStream, partnerId2charArray);
                    SSLContext sslContext = SSLContext.getDefault();
                    sslContext.init(null, createTrustAllManager(), new SecureRandom());
                    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, NoopHostnameVerifier.INSTANCE);
                    httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
                }
                else
                {
                    // 信任所有
                    SSLContext sslContext = SSLContext.getDefault();
                    sslContext.init(null, createTrustAllManager(), new SecureRandom());
                    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
                    httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
                }
            }
            else
            {
                httpClient = HttpClients.createDefault();
            }
            try (CloseableHttpResponse response = httpClient.execute(http))
            {
                if (response != null)
                {
                    if (response.getStatusLine() != null)
                    {
                        statusCode = response.getStatusLine().getStatusCode();
                    }

                    HttpEntity entity = response.getEntity();

                    // 响应内容
                    content = EntityUtils.toString(entity, Consts.UTF_8);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (httpClient != null)
            {
                httpClient.close();
            }
        }
    }

    private TrustManager[] createTrustAllManager()
    {
        return new TrustManager[]{new X509TrustManager()
        {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }
        }};
    }
}
