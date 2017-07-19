package com.zrgk.test;
import java.util.List;
import java.util.Scanner;
import com.zrgk.bean.User;
import com.zrgk.service.UserService;
import com.zrgk.service.serviceimpl.UserServiceImpl;
public class TestSuperFind {
public static void main(String[] args) {
	Scanner sca =new Scanner(System.in);
	System.out.println("请输入姓名");
	String username=sca.next();
	
	UserService service =new UserServiceImpl();
	List<User> userlist =service.superSelect(username);
	for(User u:userlist){
		System.out.println(u);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
}
