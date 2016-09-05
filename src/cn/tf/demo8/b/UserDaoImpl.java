package cn.tf.demo8.b;

import org.springframework.stereotype.Repository;

@Repository("userDaoId")
public class UserDaoImpl implements UserDao {

	@Override
	public void find() {
		System.out.println("dao 查询");
	}

}
