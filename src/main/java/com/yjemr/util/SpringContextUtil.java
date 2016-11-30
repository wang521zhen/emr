package com.yjemr.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
/**
 * 获取所有Bean集合
 * @author Administrator
 *
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext context = null;
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context = arg0;

	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		if (beanName != null && !context.containsBean(beanName)) {
			String[] str = context.getBeanDefinitionNames();
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					if (beanName.toLowerCase().equals(str[i].toLowerCase())) {
						beanName = str[i];
						break;
					}
				}
			}
		}
		return (T) context.getBean(beanName);
    }


    public static String getMessage(String key){
        return context.getMessage(key, null, Locale.getDefault());
    }

}
