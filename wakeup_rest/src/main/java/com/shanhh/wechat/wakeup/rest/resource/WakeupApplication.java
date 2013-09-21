package com.shanhh.wechat.wakeup.rest.resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@Component
public class WakeupApplication extends Application implements InitializingBean {

    @Autowired
    private WakeupResource wakeupResource;

	/** Singleton instances */
	private Set<Object> singletons = new HashSet<Object>();

	/**
	 * Constructor
	 */
	public WakeupApplication() {
	}

	/**
	 * Get Singletons
	 * 
	 * @return Set of Objects
	 */
	@Override
	public final Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> set = new HashSet<Class<?>>();
		return set;
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        singletons.add(wakeupResource);
    }
}
