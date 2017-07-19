package com.zrgk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BaseDao {
//初级封装
	// 1、获取链接的方法
	//2 关闭链接
	/**而且 数据库的驱动加载的时候十分消耗内存，所以我们的封装，把加载驱动、包括资源文件中的数据的初始 值的赋值，在一个静态
	 * 的代码块中完成**/
	private static String DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	private Connection conn;//链接
	private PreparedStatement pst =null;//预状态通道
	private ResultSet rs =null;
	static{
		//1 加载驱动
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		URL=bundle.getString("url");
		USERNAME=bundle.getString("username");
		PASSWORD=bundle.getString("password");
		try {
			DRIVER=bundle.getString("driver");
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 获取链接的方法  getConnection() 方法
	public Connection getConnection(){
		try {
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**基于预状态通道下的增删改的方法的封装
	 * 要传递参数
	 * insert into users values(null,?,?,?,?,?)
	 * **/
	public boolean doPst(String sql,List<Object> params){//null
		/**获取链接**/
		boolean flag =false;
		this.getConnection();
		/**创建通道**/
		try {
			pst=conn.prepareStatement(sql);
			//绑定参数
			if(params!=null&&params.size()>0){//为了防止空指针
				for(int i=0;i<params.size();i++){
					pst.setObject(i+1, params.get(i));
				}
			}
			int x=pst.executeUpdate();
			
			if(x>0){
				flag=false;
			}else{
				flag =true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**基于预状态通道下的查询方法**/
	public ResultSet doQuery(String sql,List<Object> params){
		//加载驱动
		//获取链接
		this.getConnection();
		//创建通道
		try {
			pst=conn.prepareStatement(sql);
			//绑定参数
			if(params.size()>0&&params!=null){
				for(int i=0;i<params.size();i++){
					pst.setObject(i+1, params.get(i));
				}
			}
			rs=pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**基于预状态通道下的查询方法**/
	public void closeAll(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
