package com.shanhh.wechat.wakeup.service.impl;

import com.shanhh.wechat.wakeup.service.ConfigService;
import com.shanhh.wechat.wakeup.util.Sha1Utils;
import com.shanhh.wechat.wakeup.util.StringComparator;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author: dan.shan
 * @since: 2013-09-21 08:52
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Override
    public boolean valid(String token, String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        String[] arrays = {token, timestamp, nonce};
        Arrays.sort(arrays, new StringComparator());

        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String sha1 = Sha1Utils.SHA1(arrays[0] + arrays[1] + arrays[2]);
        return sha1.equals(signature);
    }

}
