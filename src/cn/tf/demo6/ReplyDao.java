package cn.tf.demo6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ReplyDao implements BeanNameAware ,ApplicationContextAware ,InitializingBean,DisposableBean{
	
	public ReplyDao() {
		System.out.println("1. 初始化");
	}
	
	private String username;
	public void setUsername(String username) {
		System.out.println("2. setter 属性注入");
		this.username = username;
	}
	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("3 获得配置bean名称："+beanName +"，必须实现接口：BeanNameAware");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("4 . 获得spring容器，相当于TestApp new ClassPath... , 必须实现接口：ApplicationContextAware");
		System.out.println("---" + applicationContext);
		System.out.println("--- 也可以实现接口：BeanFactoryAware");
	}
	
	// 5 MyBeanPostProcessor  postProcessBeforeInitialization
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6.初始化前属性设置");
	}
	
	//7 初始化 (掌握)
	public void replyInit(){
		System.out.println("7. 初始化方法，需要在xml配置 <bean init-method='' >");
	}

	// 8 MyBeanPostProcessor  postProcessAfterInitialization


	public void save() {
		System.out.println("9. save 方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("10. 销毁，必须实现接口：DisposableBean");
	}

	// 掌握
	public void replyDestory(){
		System.out.println("11. 销毁，需要配置，<bean destory-method=''>");
	}
}
