package cn.tf.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo4/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		PersonDao  personDao=(PersonDao) applicationContext.getBean("personDaoId");
		personDao.addPerson();
		
	}

	

	
}
