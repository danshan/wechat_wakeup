package com.shanhh.wechat.wakeup.rest.resource;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.plugins.spring.SpringResourceFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;

/**
 * The Class TestParent.
 */
public abstract class SpringRestTestNGParent extends PowerMockTestCase {

    protected Dispatcher dispatcher;
    
    protected ApplicationContext context;

    @BeforeClass
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dispatcher = MockDispatcherFactory.createDispatcher();
        SpringResourceFactory noDefaults = new SpringResourceFactory("userResource", context, WakeupResource.class);
        dispatcher.getRegistry().addResourceFactory(noDefaults);
    }
}
