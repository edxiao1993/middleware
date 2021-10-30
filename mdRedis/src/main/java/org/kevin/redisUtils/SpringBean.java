package org.kevin.redisUtils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class SpringBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean {
    @Override
    public void setBeanName(String s) {
        // BeanNameAware
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // BeanFactory
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // ApplicationContextAware
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // InitializingBean
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // BeanPostProcessor
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // BeanPostProcessor
        return null;
    }
}
