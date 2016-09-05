package cn.tf.demo3;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.tf.demo1.UserDao;

public class TestApp {
	

	@Test
	public void test1(){
		String xmlpath="cn/tf/demo1/beans.xml";
		
		BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource(xmlpath));
		
		UserDao userDao=(UserDao) beanFactory.getBean("userDao");
		userDao.save();
	}

}
