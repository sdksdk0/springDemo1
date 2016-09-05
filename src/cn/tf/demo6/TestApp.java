package cn.tf.demo6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo6/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		ReplyDao  replyDao=(ReplyDao) applicationContext.getBean("replyDaoId");
		replyDao.save();
		
	}

	

	
}
