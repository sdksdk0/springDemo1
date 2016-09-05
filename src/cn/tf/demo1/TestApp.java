package cn.tf.demo1;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo1/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}

}
