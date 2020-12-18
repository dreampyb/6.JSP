package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//DB���� �� ��������(Connection��ü)�� ������ �ִ� �޼ҵ�
	public static Connection getConnection() {
		 Connection conn=null;

//	void Test() {
//		String status="����";

		 try{
			 Context init = new InitialContext(); //javax.naming
			 DataSource ds //javax.sql
			 =(DataSource)init.lookup("java:comp/env/jdbc/MySqlDB");
			 conn=ds.getConnection();       //java.sql
			 conn.setAutoCommit(false);     // Ŀ���� �ڵ����� �Ǵ� ���� ����
			 System.out.println("DB���� ����");
//			 status="����";
			}catch(Exception e){
				System.out.println("����!! DB���� ������");
			e.printStackTrace();
			} 
		 	return conn;
	}
	public static void close(Connection con) {
		
		if(con!=null) {		
		try {
			con.close();
			 System.out.println("Connection �ݳ��Ϸ�");
		} catch (SQLException e) {
			System.out.println("����!! Connection�ݳ�����");
			e.printStackTrace();
		}
	}
}
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
				 System.out.println("Statement �ݳ��Ϸ�");
			} catch (SQLException e) {
				System.out.println("����!! Statement�ݳ�����");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
		try {
			rs.close();
			 System.out.println("ResultSet �ݳ��Ϸ�");
		} catch (SQLException e) {
			System.out.println("����!! ResultSet�ݳ�����");
			e.printStackTrace();
		}
	}
	}	
	public static void commit(Connection conn) {
		if(conn!=null) {
		try {
			conn.commit();
			 System.out.println("Connection Ŀ�ؿϷ�");
		} catch (SQLException e) {
			System.out.println("����!! Connection Ŀ�ؿ���");
			e.printStackTrace();
		}
	}
	}
	public static void rollback(Connection conn) {
		if(conn!=null) {
		try {
			conn.rollback();
			 System.out.println("Connection �ѹ�Ϸ�");
		} catch (SQLException e) {
			System.out.println("����!! Connection�Ѻ�����");
			e.printStackTrace();
		}
	}
	}
	
}
