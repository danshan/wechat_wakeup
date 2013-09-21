package com.shanhh.wechat.wakeup.rest.resource;

import com.shanhh.wechat.wakeup.rest.util.MyMediaType;
import com.shanhh.wechat.wakeup.service.ConfigService;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * @author: dan.shan
 * @since: 2013-09-21 08:29
 */
@Component
public class ConfigResource {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigResource.class);

    @Autowired
    private ConfigService configService;

    private static final String PROPERTIES_NAME = "service.properties";
    private static String CONFIG_TOKEN;

    static {
        try {
            CONFIG_TOKEN = PropertiesLoaderUtils.loadAllProperties(PROPERTIES_NAME).getProperty("config.token");
        } catch (IOException e) {
            LOG.error("load config token failed", e);
        }
    }

    @GET
    @Path("/")
    @NoCache()
    @Produces({MyMediaType.APPLICATION_JSON_CHARSET})
    public Response configResource(@QueryParam("signature") String signature,
                                   @QueryParam("timestamp") String timestamp,
                                   @QueryParam("nonce") String nonce,
                                   @QueryParam("echostr") String echostr,
                                   @Context HttpRequest request) {

        if (configService.valid(CONFIG_TOKEN, signature, timestamp, nonce)) {
            return Response.status(Response.Status.OK)
                    .entity(echostr)
                    .type(MediaType.TEXT_PLAIN)
                    .encoding("utf-8")
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }

    }

}
