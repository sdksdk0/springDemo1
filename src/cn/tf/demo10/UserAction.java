package cn.tf.demo10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class UserAction {
	
	@Autowired
	private UserService userService;
	
	public void login(){
		System.out.println("登录");
		userService.userLogin();
	}

}
