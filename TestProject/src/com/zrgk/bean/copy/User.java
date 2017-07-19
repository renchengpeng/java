package src.com.zrgk.bean.copy;

import java.util.Date;

public class User {
	private int id;//id编号
	private String name;//姓名
	private String pwd;//密码
	private int age;//年龄
	private String sex;//性别
	private Date birthday;//生日
	public User(){
	}
	public User(int id,String name){
		this.id=id;
		this.name=name;
	}
	public User(int id,String name,String pwd){
		this(id,name);
		this.pwd=pwd;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "id:#"+this.id+"\tname:"+this.name+"\tage:"+this.age+"\t:生日"+this.birthday;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj!=null){
			if(obj instanceof User){
				User user =(User)obj;
				return this.getId()==user.getId()&&this.getName().equals(user.getName());
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return id;
	}
}
