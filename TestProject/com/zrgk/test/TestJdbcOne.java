package com.zrgk.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TestJdbcOne {
public static void main(String[] args) {
	/**java 去操作jdbc 有五个步骤**/
	/**第一步：加载驱动
	 * 第一种方式
	 * DrivderManager  类下的一个方法， registerDriver(new Driver());
	 * **/
	/*	try {
	DriverManager.registerDriver(new Driver());
	} catch (SQLException e) {
	e.printStackTrace();
	}*/
	/**加載驅動最常用的方式如下
	 * 第一步：加载驱动**/
	Connection conn =null;
	Statement st =null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取链接
		/**Connection 接口   getConnection()
		 * DriverManager 是用来获取链接的。所以他是类
		 * **/
	//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qibanjdbc", "root", "123");

	//conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qibanjdbc?useUnicode=true&characterEncoding=utf-8", "root", "123");
	//链接的如果是本机
		conn=DriverManager.getConnection("jdbc:mysql:///qibanjdbc", "root", "123");
		/**第三步：创建通道
		 * Statement 通道 也是一个接口   状态通道
		 * **/
		st=conn.createStatement();
	
		/**第四步：执行sql**/
		String sql ="insert into users(userid,username) values (null,'tom')";
		/**
		 * 通道下有一些方法
		 *  返回值return 			方法名
		 *  	int值				executeUpdate(sql);增删改的操作
		 * 		boolean					execute(); 当返回的是true 执行的是查询、如果是false 就说明是增删改
		 * 		ResultSet 结果集	 		executeQuery();
		 * **/
		int result =st.executeUpdate(sql);
		System.out.println(result);
		if(result>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		
		/**第五步：关闭链接**/
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
			}//sql异常
		}
		
	}
}
}
