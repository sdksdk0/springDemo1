package cn.tf.demo8.a;

import org.springframework.stereotype.Component;

@Component(value = "orderDaoId")
public class OrderDaoImpl implements OrderDao {

	public void save() {
		System.out.println("_hello save");
	}

}
