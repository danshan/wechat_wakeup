package com.shanhh.wechat.wakeup.rest.util;

import javax.ws.rs.core.MediaType;

/**
 * The type My media type.
 * @author jack.zhang
 */
public class MyMediaType extends MediaType {

    /**
     * A {@code String} constant representing "{@value #APPLICATION_JSON}" media type.
     */
    public final static String APPLICATION_JSON_CHARSET = APPLICATION_JSON + ";charset=utf-8";
    /**
     * A {@link MediaType} constant representing "{@value #APPLICATION_JSON}" media type.
     */
    public final static MediaType APPLICATION_JSON_CHARSET_TYPE = new MediaType("application", "json", "utf-8");

}

