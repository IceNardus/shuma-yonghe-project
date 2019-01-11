package com.hoperun.shuma.common.utils;

import java.security.MessageDigest;

/***
 * 处理MD5字符串加密
 */
public class MD5Util {

    private static final String DEFAULT_CHARSET = "utf-8";

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * 根据指定编码格式进行MD5加密
     *
     * @param origin      源字符串
     * @param charsetname 编码格式
     * @return
     * @author feng_wei
     */
    public static String getMd5(String origin, String charsetname) {
        return MD5Encode(origin, charsetname);
    }

    /**
     * 使用默认编码进行MD5加密
     *
     * @param origin
     * @return
     * @author feng_wei
     */
    public static String getMd5(String origin) {
        return getMd5(origin, DEFAULT_CHARSET);
    }

    /**
     * 根据指定编码格式进行MD5加密并返回大写格式
     *
     * @param origin
     * @param charsetname
     * @return
     */
    public static String getMd5Upper(String origin, String charsetname) {
        return getMd5(origin, charsetname).toUpperCase();
    }

    /**
     * 根据默认编码进行MD5加密并返回大写格式
     *
     * @param origin
     * @param charsetname
     * @return
     */
    public static String getMd5Upper(String origin) {
        return getMd5Upper(origin, DEFAULT_CHARSET);
    }

    /**
     * 返回16位MD5加密字符
     *
     * @param SourceString
     * @return
     * @throws Exception
     */
    public static String getMd5Upper16(String SourceString) {
        return getMd5Upper(SourceString).substring(8, 24);
    }
}
