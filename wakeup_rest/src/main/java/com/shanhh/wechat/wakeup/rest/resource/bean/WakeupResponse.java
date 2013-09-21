package com.shanhh.wechat.wakeup.rest.resource.bean;

import com.shanhh.wechat.wakeup.rest.util.MyMediaType;

import javax.ws.rs.core.Response;

/**
 * Date: 13-9-11
 * Time: 下午5:26
 *
 * @author jack.zhang
 */
public class WakeupResponse {

    public WakeupResponse() {
    }

    /**
     * 返回status code, 成功200, 参数错误400
     */
    private Integer code;

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    public Response buildResponse(){
        return Response.status(code)
                .entity(this)
                .type(MyMediaType.APPLICATION_JSON_CHARSET)
                .encoding("utf-8")
                .build();
    }

}
