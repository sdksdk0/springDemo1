package cn.tf.demo2;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void test1(){
		String xmlpath="cn/tf/demo2/beans.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlpath);
		BookService  bookService=(BookService) applicationContext.getBean("bookServiceId");
		bookService.addBook();
		
	}
	

}
