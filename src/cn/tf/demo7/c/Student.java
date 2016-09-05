package cn.tf.demo7.c;

public class Student {
	
	
	private Teacher teacher;
	private String pi;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getPi() {
		return pi;
	}
	public void setPi(String pi) {
		this.pi = pi;
	}
	@Override
	public String toString() {
		return "Student [teacher=" + teacher + ", pi=" + pi + "]";
	}
	
	
	
	
}
