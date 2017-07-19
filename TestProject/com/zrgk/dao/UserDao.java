package com.zrgk.dao;

import java.util.List;

import com.zrgk.bean.User;

public interface UserDao {
	/**修改的方法**/
	public abstract int updateUser(User user);//修改的信息是封装到user 对象里的
	//查询方法
	List<User> getAllUsers();
	//登陆
	User denglu(String name,String pwd);
	
	//模糊查询
	List<User> getAllUsers(String name);
	//基于与状态通道的增加
	int preparedStatementRegister(User user);
	
	//高级查询，用的封装实现的
	List<User> superSelect(String username);
	
}
