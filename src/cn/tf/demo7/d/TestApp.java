package cn.tf.demo7.d;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void demo01() throws Exception{
		String xmlPath = "cn/tf/demo7/d/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		CollBean collbean = (CollBean) applicationContext.getBean("collbeanId");
		System.out.println(collbean);
	}

}
