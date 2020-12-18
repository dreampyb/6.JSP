package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	//DB연결 후 연결정보(Connection객체)를 리턴해 주는 메소드
	public static Connection getConnection() {
		 Connection conn=null;

//	void Test() {
//		String status="실패";

		 try{
			 Context init = new InitialContext(); //javax.naming
			 DataSource ds //javax.sql
			 =(DataSource)init.lookup("java:comp/env/jdbc/MySqlDB");
			 conn=ds.getConnection();       //java.sql
			 conn.setAutoCommit(false);     // 커밋이 자동으로 되는 것을 방지
			 System.out.println("DB연결 정상");
//			 status="성공";
			}catch(Exception e){
				System.out.println("오류!! DB연결 비정상");
			e.printStackTrace();
			} 
		 	return conn;
	}
	public static void close(Connection con) {
		
		if(con!=null) {		
		try {
			con.close();
			 System.out.println("Connection 반납완료");
		} catch (SQLException e) {
			System.out.println("오류!! Connection반납오류");
			e.printStackTrace();
		}
	}
}
	public static void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
				 System.out.println("Statement 반납완료");
			} catch (SQLException e) {
				System.out.println("오류!! Statement반납오류");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
		try {
			rs.close();
			 System.out.println("ResultSet 반납완료");
		} catch (SQLException e) {
			System.out.println("오류!! ResultSet반납오류");
			e.printStackTrace();
		}
	}
	}	
	public static void commit(Connection conn) {
		if(conn!=null) {
		try {
			conn.commit();
			 System.out.println("Connection 커밑완료");
		} catch (SQLException e) {
			System.out.println("오류!! Connection 커밑오류");
			e.printStackTrace();
		}
	}
	}
	public static void rollback(Connection conn) {
		if(conn!=null) {
		try {
			conn.rollback();
			 System.out.println("Connection 롤백완료");
		} catch (SQLException e) {
			System.out.println("오류!! Connection롤벡오류");
			e.printStackTrace();
		}
	}
	}
	
}
