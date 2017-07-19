package com.zrgk.dao.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import com.zrgk.bean.User;
import com.zrgk.dao.BaseDao;
import com.zrgk.dao.UserDao;
public class UserDaoImpl extends BaseDao implements UserDao {
	public int updateUser(User user) {//写jdbc 的代码
		Connection conn =null;
		Statement st =null;
		 int result=0;
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2 、获取链接
			conn=DriverManager.getConnection("jdbc:mysql:///qibanjdbc?useUnicode=true&characterEncoding=utf-8","root","123");
			//3、 创建通道
			st=conn.createStatement();
			//4、执行sql
			String sql ="update users set username='"+user.getName()+"'"+" where userid="+user.getId();
			result=	st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	//查询的业务
	public List<User> getAllUsers() {//jdbc
		Connection conn =null;
		Statement st=null;
		ResultSet rs =null;
		List<User> userlist =new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql:///qibanjdbc?useUnicode=true&characterEncoding=utf-8","root","123");
			st= conn.createStatement();
			String sql ="select * from users";
			rs =st.executeQuery(sql);
			// rs.next()
			User user=null;
			while(rs.next()){
			user =new User();
				user.setId(rs.getInt("userid"));//id
				user.setName(rs.getString("username"));
				//user.setBirthday((Date)rs.getObject("birthday"));
				userlist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userlist;
	}
	
	//登陆的实现
	public User denglu(String name, String pwd) {
	System.out.println("驱动加载中...");
	Statement st =null;
	ResultSet rs =null;
	User user =null;
	try{
		//创建通道
		st=this.getConnection().createStatement();
		//执行sql
		String sql="select * from users where username ='"+name+"'"+" and password='"+pwd+"'";
		//select * from users where username ='jack' and password='123'
		System.out.println(sql);
		//select * from users where username ='jack' or '1=1' and password='111'
		rs =st.executeQuery(sql);
		while(rs.next()){
			user =new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
		}
	}catch(Exception e){
	}finally{
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		this.closeAll();
	}
		return user;
	}
	//模糊查询
	public List<User> getAllUsers(String name) {//jdbc代码
		ResultSet rs =null;
		User u =null;
		List<User> userlist =new ArrayList<User>();
		try{
		System.out.println("驱动加载中");
		//3/创建通道
		Statement st =this.getConnection().createStatement();
		
		
		//执行sql 											'%关羽%'	
		String sql ="select * from users where username like '%"+name+"%'";
		
	rs =	st.executeQuery(sql);
		while(rs.next()){
			u=new User();
			u.setId(rs.getInt("userid"));
			u.setName(rs.getString("username"));
			userlist.add(u);
		}
		}catch(Exception e ){
			
		}finally{
		}
		return userlist;
	}
	public int preparedStatementRegister(User user) {//jdbc
		int result=0;
		PreparedStatement pst= null;
		try {
	
		System.out.println("驱动加载中....");
		
		//创建通道 
		/**创建PreparedStatement 通道**/  			 //1 2 3 4 5
		String sql ="insert into users values(null,?,?,?,?,?)";
		// 这五个问号是占位符
		/*pst=this.getConnection().prepareStatement(sql);*/
		//绑定值
		/*pst.setString(1,user.getName());//绑定值
		pst.setString(2, user.getSex());
		pst.setInt(3, user.getAge());*/
		List<Object> params =new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getSex());
		params.add(user.getAge());
		//java.util.Date
		//java.sql.Date
		//就需要对生日进行处理，把uitl.Date 转成sql.Date,通过sql Date 的构造
		//java.sql.Date mybirthday =new java.sql.Date(long  l);
	/*	long time= 	user.getBirthday().getTime();
		java.sql.Date mybirthday =new java.sql.Date(time);*/
		/*pst.setDate(4, mybirthday);//sqlDate
		pst.setString(5, user.getPwd());
		
*/
		params.add(user.getBirthday());
		params.add(user.getPwd());
		
		boolean b =this.doPst(sql, params);	
		if(b==false){//增删改
			result =1;
		}
		
		//执行sql 
		//result =	pst.executeUpdate();//已经预编译了所有注意不要传sql
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.closeAll();
		}

		return result;
	}
	public List<User> superSelect(String username) {
		List<User> userlist =new ArrayList<User>();
		User user =null;
		try{
		System.out.println("驱动加载中...");
		String sql ="select * from users where username like ?";
		List<Object> params =new ArrayList<Object>();
		params.add("%"+username+"%");//绑定
		ResultSet rs =this.doQuery(sql, params);
		while(rs.next()){
			user=new User();
			user.setId(rs.getInt("userid"));
			user.setName(rs.getString("username"));
			user.setAge(rs.getInt("age"));
			user.setBirthday(rs.getDate("birthday"));
			user.setSex(rs.getString("sex"));
			userlist.add(user);
		}
		}catch(Exception e){
			
		}finally{
			
			
			this.closeAll();
		}
		return userlist;
	}

}
