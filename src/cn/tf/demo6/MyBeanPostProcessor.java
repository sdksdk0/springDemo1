package cn.tf.demo6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 5 实现BeanPostProcessor接口，称为后处理bean
 * * 在执行目标方法之前可以进行对象的处理。
 * * aop底层，可以通过后处理bean提供代理对象
 * * 后处理bean的实现只要配置到spring容器中即可<bean class="">
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("5 . 初始化之前执行");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("8 . 初始化之后执行");
		return bean;
	}



}
