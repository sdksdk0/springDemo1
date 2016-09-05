package cn.tf.demo8.a;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo8/a/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlpath);
		OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDaoId");
		orderDao.save();
	}

	

	
}
