package com.zrgk.test;


import java.util.Scanner;

import com.zrgk.bean.User;
import com.zrgk.service.UserService;
import com.zrgk.service.serviceimpl.UserServiceImpl;

public class TestUpdateUser {
public static void main(String[] args) {//控制 ----调用dao 
	// service 业务层
	Scanner sca =new Scanner(System.in);
	System.out.println("请输入id");
	Integer id =sca.nextInt();
	System.out.println("请输入修改后的名字");
	String name =sca.next();
	User user =new User();
	
	user.setId(id);
	user.setName(name);
	
	//程序入口去调用Service 
	UserService service =new UserServiceImpl();
	int result =service.update(user);
	
	if(result>0){
		System.out.println("修改成功");
	}else{
		System.out.println("修改失败，系统没有此人");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
