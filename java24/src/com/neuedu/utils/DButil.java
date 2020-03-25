package com.neuedu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DButil {
//	 * 1、建立连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		BasicDataSource dataSource=new BasicDataSource();
		//四个必选项
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/java24?characterEncoding=UTF-8&useUnicode=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		//其他设置(可选设置)
		dataSource.setInitialSize(8);
		dataSource.setMaxWaitMillis(5000);
		dataSource.setMaxTotal(20);
		dataSource.setMinIdle(3);
		Connection conn=dataSource.getConnection();
		return conn;
		/*// 1加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2连接准备
		String url = "jdbc:mysql://localhost:3306/java24?characterEncoding=UTF-8&useUnicode=true";
		String username = "root";
		String password = "root";
		// 3建连接
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;*/
		
		

					 
	}
//	 * 2、【事务】开启事务
	public static void beginTransaction(Connection conn) throws SQLException{
		conn.setAutoCommit(false);
	}
	
//	 * 3、执行数据库相关操作---用户开发
	
//	 * 4、【事务】提交事务
	public static void commit(Connection conn) throws SQLException{
		conn.commit();
	}
//	 * 5、【事务】回滚事务
	public static void rollback(Connection conn) throws SQLException{
		conn.rollback();
	}
//	 * 6、关闭连接
	public static void closeDB(ResultSet rs,Statement st,Connection conn) throws SQLException{
		//关闭每一个都需要先做非空判断，防止出现空指针异常
		if(rs!=null){
			rs.close();
		}
		if(st!=null){
			st.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
