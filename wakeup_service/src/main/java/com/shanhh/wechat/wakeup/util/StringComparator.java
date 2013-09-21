package com.shanhh.wechat.wakeup.util;

import java.util.Comparator;

/**
 * @author: dan.shan
 * @since: 2013-09-21 09:21
 */
public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
