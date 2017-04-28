package com.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanLocator
 * @Description:取bean组件名的bean
 * @author dengqingkui
 * @date 2015-4-22 下午4:56:59
 */
@Component
public class BeanLocator implements ApplicationContextAware  {

    private static ApplicationContext applicationContext ;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> cla) {
        Object obj = applicationContext.getBean(beanName, cla);
        if(obj != null){
            return (T)obj;
        }
        return null;
    }

    public static <T> T getBean(Class<T> cls){
        return applicationContext.getBean(cls);
    }

}
