package com.zrgk.test;
import java.util.List;
import com.zrgk.bean.User;
import com.zrgk.service.UserService;
import com.zrgk.service.serviceimpl.UserServiceImpl;
public class TestFindAll {
public static void main(String[] args){
	UserService service =new UserServiceImpl();
	List<User> userlist =service.findAllUsers("o");
	for(User u:userlist){
		System.out.println(u);
	}
}
}
