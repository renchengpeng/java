package com.zrgk.service.serviceimpl;

import java.util.List;

import com.zrgk.bean.User;
import com.zrgk.dao.UserDao;
import com.zrgk.dao.daoimpl.UserDaoImpl;
import com.zrgk.service.UserService;

public class UserServiceImpl implements  UserService {//service 层 去调用dao
	UserDao dao =new UserDaoImpl();
	public int update(User user) {
		return dao.updateUser(user);
	}
	public List<User> findAllUsers() {
		return dao.getAllUsers();
	}
	public User login(String name, String pwd) {
		return dao.denglu(name,pwd);
	}
	public List<User> findAllUsers(String name) {
		return dao.getAllUsers(name);
	}
	public int preparedStatementRegister(User user) {
		return dao.preparedStatementRegister(user);
	}
	
	
	
	public List<User> superSelect(String username) {
		
		return dao.superSelect(username);
	}

}
