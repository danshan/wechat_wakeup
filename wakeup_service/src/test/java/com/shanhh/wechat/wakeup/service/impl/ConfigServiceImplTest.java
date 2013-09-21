package com.shanhh.wechat.wakeup.service.impl;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * @author: dan.shan
 * @since: 2013-09-21 09:54
 */
public class ConfigServiceImplTest {

    @Test
    public void testValid() {
        String nonce = "1379168968";
        String signature = "2dc2db660ce13c45cf43e06003b8907c29991e48";
        String timestamp = "1379771576";
        String token = "fuck";

        assertTrue(new ConfigServiceImpl().valid(token, signature, timestamp, nonce));
    }

}
