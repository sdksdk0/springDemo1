package cn.tf.demo5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo5/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		TopicDao  topicDao=(TopicDao) applicationContext.getBean("topicDaoId");
		System.out.println(topicDao);
		
	}

	

	
}
