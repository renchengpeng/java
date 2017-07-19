package com.zrgk.test;
import java.util.Scanner;
import com.zrgk.bean.User;
import com.zrgk.service.UserService;
import com.zrgk.service.serviceimpl.UserServiceImpl;
public class TestLogin {
public static void main(String[] args) {
	Scanner sca =new Scanner(System.in);
	System.out.println("请输入用户名");
	String username =sca.nextLine();
	System.out.println("请输入密码");
	String pwd =sca.nextLine();
	UserService userService =new UserServiceImpl();
	User user =userService.login(username, pwd);
	if(user==null){
		System.out.println("用户名或者密码错误");
	}else{
		System.out.println("欢迎"+user.getName());
	}
}
}
