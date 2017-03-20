package com.kaer.athena.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Kelvin on 2016/8/23 0023.
 */
public class StringUtil {
    private static final String TAG = "StringUtil";

    /**
     * Returns true if the string is null or 0-length.
     *
     * @param str the string to be examined
     * @return true if str is null or zero length
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    /**
     * Returns true if a and b are equal, including if they are both null.
     * <p><i>Note: In platform versions 1.1 and earlier, this method only worked well if
     * both the arguments were instances of String.</i></p>
     *
     * @param a first CharSequence to check
     * @param b second CharSequence to check
     * @return true if a and b are equal
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 生成MD5
     */
    public static String getMD5(String source) {
        return getMD5(source.getBytes());
    }

    /**
     * 生成MD5
     */
    public static String getMD5(byte[] source) {
        String s = null;
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest
                    .getInstance("MD5");
            md.update(source);

			/*
             *  MD5 的计算结果是一个 128 位的长整数，用字节表示就是 16 个字节，
			 *  每个字节用 16 进制表示的话，使用两个字符，所以表示成 16 进制需要 32 个字符。
			 *  不采用String.format进行格式化，String.format比较慢，慢差不多50倍。
			 */
            byte tmp[] = md.digest();

            char str[] = new char[16 * 2];

            int k = 0;
            for (int i = 0; i < 16; i++) {
                // 从第一个字节开始，对 MD5 的每一个字节
                // 转换成 16 进制字符的转换
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 数据库内读出来的urls转换成list
     *
     * @param urlString
     * @return
     */
    public static List<String> stringToUrls(String urlString) {
        List<String> list = new ArrayList<>();
        if (null != urlString) {
            String[] urls = urlString.split(";");
            for (String url : urls) {
                if (null != urls && urls.length > 0) {
                    list.add(url);
                }
            }
        }
        return list;
    }

    /**
     * 是否是电话号码
     * @param input
     * @return
     */
    public static boolean matchPhoneNumber(String input) {
        // 电话号码正则表达式
        final String PHONEURL_STRING = "((?<=\\D|^)((\\d{7,13})|((\\d{3,4}-)?\\d{7,8}))(?=\\D|$))";
        final Pattern patternPhoneNumber = Pattern.compile(PHONEURL_STRING, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = patternPhoneNumber.matcher(input);
        return matcher.matches();
    }

    /**
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 创建指定数量的随机字符串
     *
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }

    /**
     * base64加密
     * @param str
     * @return
     */
    public static String base64Encode(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * base64解密
     * @param s
     * @return
     */
    public static String base64Decode(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
