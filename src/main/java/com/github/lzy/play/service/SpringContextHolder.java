package com.github.lzy.play.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-27
 */
@Service
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> beanType) {
		return applicationContext.getBean(beanType);
	}
}
