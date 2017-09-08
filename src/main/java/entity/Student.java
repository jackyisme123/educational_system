package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Student implements Serializable{
	private Integer StuId;
	private String pwd;
	private String name;
	private String gender;
	private Integer age;
	private Object mobile;
	private String address;
	public Integer getStuId() {
		return StuId;
	}
	public void setStuId(Integer stuId) {
		StuId = stuId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Object getMobile() {
		return mobile;
	}
	public void setMobile(Object mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
