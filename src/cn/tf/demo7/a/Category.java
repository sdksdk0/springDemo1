package cn.tf.demo7.a;

public class Category {
	
	private Integer cid;
	private String name;
	private Integer money;
	
	
	public Category(Integer cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}
	public Category(String name, Integer money) {
		super();
		this.name = name;
		this.money = money;
	}
	public Category() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + ", money=" + money
				+ "]";
	}
	
	

}
