package com.glen.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class mysqldemo {

	static String sql = null;
	static mysqlconnect db1 = null;
//	static ResultSet ret = null;

	public static void main(String[] args) {
		for(int x=0;x<5;x++){
		int i=2;
		sql = "insert into test1 values"+"("+i+","+(i+1)+")";// SQL语句
		db1 = new mysqlconnect(sql);// 创建mysqlconnect对象

		try {
			db1.pst.executeUpdate();
//			db1.pst.executeQuery();// 执行语句
//			ret = db1.pst.executeQuery();// 执行语句，得到结果集
//			
//			while (ret.next()) {
//				String username = ret.getString("name");
//				System.out.println(username);
//			} // 显示数据
			
//			ret.close();
			db1.close();// 关闭连接
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
}