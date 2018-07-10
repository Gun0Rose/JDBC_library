package com.libmanager.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class FinDbUtil {
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // 数据库连接地址
	private String dbUserName="fin_admin"; // 用户名
	private String dbPassword="admin"; // 密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // 驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		FinDbUtil dbUtil=new FinDbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

