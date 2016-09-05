package cn.tf.demo10;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void demo01() throws Exception{
		String xmlPath = "cn/tf/demo10/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		UserAction userAction = (UserAction)applicationContext.getBean("userActionId");
		userAction.login();
	}

}
