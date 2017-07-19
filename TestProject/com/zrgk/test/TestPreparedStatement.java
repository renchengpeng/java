package com.zrgk.test;
import java.util.Scanner;
import com.zrgk.bean.User;
import com.zrgk.service.UserService;
import com.zrgk.service.serviceimpl.UserServiceImpl;
import com.zrgk.util.DateUtil;
public class TestPreparedStatement {
//PreparedStatement 是一个接口，他是Statement 的子接口
	public static void main(String[] args) {
		Scanner sca =new Scanner(System.in);
		//以增加为例
		System.out.println("请输入用户id");
		int  id=sca.nextInt();
		System.out.println("请输入用户名");
		String username=sca.next();
		System.out.println("请输入性别");
		String sex =sca.next();
		System.out.println("请输入年龄");
		int age =sca.nextInt();
		System.out.println("请输入生日");
		String birthday =sca.next();
		System.out.println("请输入密码");
		String pwd =sca.next();
		User user =new User();
		user.setId(id);
		user.setName(username);
		user.setSex(sex);
		user.setAge(age);
		user.setBirthday(DateUtil.strToDate(birthday));//时间的工具类 
		user.setPwd(pwd);
		UserService userservice =new UserServiceImpl();
		int result =userservice.preparedStatementRegister(user);//用PreparedStatement 完成注册
		if(result>0){
			System.out.println("录入成功");
		}else{
			System.out.println("添加失败");
		}
	}
}
