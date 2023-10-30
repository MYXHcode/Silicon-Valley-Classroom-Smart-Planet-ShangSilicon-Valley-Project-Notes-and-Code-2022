package com.myxh.smart.planet.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class UrlUtil
{
    public static void main(String[] args)
    {
        System.out.println(getParam("http://smartplanet.free.idcfengye.com/#/live/info/4?recommend=1", "recommend"));
    }

    /**
     * 获取请求地址中的某个参数
     *
     * @param url  ure
     * @param name 名称
     * @return 请求地址中的某个参数
     */
    public static String getParam(String url, String name)
    {
        return urlSplit(url).get(name);
    }

    /**
     * 去掉 url 中的路径，留下请求参数部分
     *
     * @param url url 地址
     * @return strAllParam url 请求参数部分
     */
    private static String truncateUrlPage(String url)
    {
        String strAllParam = null;
        String[] arrSplit;
        url = url.trim();
        arrSplit = url.split("[?]");

        if (url.length() > 1)
        {
            if (arrSplit.length > 1)
            {
                for (int i = 1; i < arrSplit.length; i++)
                {
                    strAllParam = arrSplit[i];
                }
            }
        }

        return strAllParam;
    }

    /**
     * 将参数存入 map 集合
     *
     * @param url url 地址
     * @return mapRequest url 请求参数部分存入 map 集合
     */
    public static Map<String, String> urlSplit(String url)
    {
        Map<String, String> mapRequest = new HashMap<>();
        String[] arrSplit;
        String strUrlParam = truncateUrlPage(url);

        if (strUrlParam == null)
        {
            return mapRequest;
        }

        arrSplit = strUrlParam.split("&");

        for (String strSplit : arrSplit)
        {
            String[] arrSplitEqual;
            arrSplitEqual = strSplit.split("=");

            // 解析出键值
            if (arrSplitEqual.length > 1)
            {
                // 正确解析
                mapRequest.put(arrSplitEqual[0], strSplit.substring(arrSplitEqual[0].length() + 1));
            }
            else
            {
                if (!arrSplitEqual[0].isEmpty())
                {
                    // 只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }

        return mapRequest;
    }
}
