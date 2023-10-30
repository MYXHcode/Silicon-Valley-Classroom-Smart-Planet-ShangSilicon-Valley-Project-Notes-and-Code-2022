package com.myxh.smart.planet.wechat.utils;

import java.security.MessageDigest;

/**
 * @author MYXH
 * @date 2023/10/17
 */
public class SHA1
{
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes)
    {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);

        for (byte aByte : bytes)
        {
            buf.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[aByte & 0x0f]);
        }

        return buf.toString();
    }

    public static String encode(String str)
    {
        if (str == null)
        {
            return null;
        }

        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());

            return getFormattedText(messageDigest.digest());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
