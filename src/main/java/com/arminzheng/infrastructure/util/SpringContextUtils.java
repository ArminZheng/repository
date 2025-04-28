package com.arminzheng.infrastructure.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Context Utils
 *
 * @author armin
 * @version 2022.4.17
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static String getProperty(String path) {
        return applicationContext.getEnvironment().getProperty(path);
    }

    public static Object getBean(String name) throws BeansException {
      if (applicationContext == null) {
        return null;
      }
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
      if (applicationContext == null) {
        return null;
      }
        return applicationContext.getBean(name, requiredType);
    }
}
