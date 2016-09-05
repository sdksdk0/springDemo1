package cn.tf.demo7.c;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo7/c/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		Student  company= (Student) applicationContext.getBean("studentId");
		System.out.println(company);
		
	}

	

	
}
