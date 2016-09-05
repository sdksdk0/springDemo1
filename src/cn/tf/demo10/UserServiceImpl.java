package cn.tf.demo10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	@Qualifier("userDaoId")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void userLogin() {
		System.out.println("service 执行登录");
		userDao.find();
	}

}
