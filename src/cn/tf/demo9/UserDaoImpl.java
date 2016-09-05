package cn.tf.demo9;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public void save() {
		
		System.out.println("hello spring");
	}
	
	public UserDaoImpl(){
		System.out.println("构造方法");
	}
}
