package com.shanhh.wechat.wakeup.service;

/**
 * @author: dan.shan
 * @since: 2013-09-21 08:45
 */
public interface ConfigService {

    /**
     * 公众平台用户提交信息后，微信服务器将发送GET请求到填写的URL上，并且带上四个参数<br/>
     * 加密/校验流程：<br/>
     * 1. 将token、timestamp、nonce三个参数进行字典序排序<br/>
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密<br/>
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信<br/>
     * @param token
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @return
     */
    boolean valid(String token, String signature, String timestamp, String nonce);

}
