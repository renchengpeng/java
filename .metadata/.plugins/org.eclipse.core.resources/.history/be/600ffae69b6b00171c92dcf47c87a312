package com.zrgk.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.zrgk.dao.BaseDao;

public class TestBatch {

	public static void main(String[] args) {
		String sql = "insert into rcp values(?)";
		BaseDao base = new BaseDao();
		PreparedStatement conn;
		try {
			conn = base.getConnection().prepareStatement(sql);
			for (int i = 20; i < 40; i++) {
				conn.setInt(1, i+1);
				conn.addBatch();
			}
			conn.executeBatch();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("tian....");
	}
}
