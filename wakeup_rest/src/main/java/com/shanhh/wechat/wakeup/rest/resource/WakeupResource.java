package com.shanhh.wechat.wakeup.rest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

/**
 * The type User resource.
 *
 * @author jack.zhang
 */
@Component
@Path("/wakeup")
public class WakeupResource {

    @Autowired
    private ConfigResource configResource;

    @Path("/config")
    public ConfigResource configResource() {
        return configResource;
    }
}
