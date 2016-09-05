package cn.tf.demo4;

public class MyFactory {
	
	//静态工厂
/*	public static PersonDao  createPersonDao(){
		return new PersonDaoImpl();	
	}*/
	
	
	//实例工厂
	public PersonDao  createPersonDao(){
		return new PersonDaoImpl();	
	}
}
