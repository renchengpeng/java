package com.zrgk.service;
import java.util.List;
import com.zrgk.bean.User;
public interface UserService {
	//修改的方法
	public abstract int update(User user);
	//查询
	//查询全部用户信息
	List<User> findAllUsers();
	//模糊查询	
	List<User>  findAllUsers(String name);
	//登陆方法
	User login(String name,String pwd);
	//preparedStatementRegister() 预状态通道的增加
	public int preparedStatementRegister(User user);
	//高级封装下的查询
	List<User> superSelect(String username);
}
