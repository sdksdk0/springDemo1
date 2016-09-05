package cn.tf.demo8.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //默认名称为类名（首字母小写）
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	public void login(){
		System.out.println("登录");
		userService.userLogin();
	}

}
