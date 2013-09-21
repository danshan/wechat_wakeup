package com.shanhh.wechat.wakeup.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: dan.shan
 * @since: 2013-09-21 09:40
 */
public class Sha1Utils {

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            buf.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return buf.toString();
    }

    public static String SHA1(String text) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            return convertToHex(md.digest(text.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

}
