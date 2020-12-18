package memoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class memoDAO {

	Connection conn=null;
	memoDAO( ){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection(
					 "jdbc:mysql://192.168.0.178:38751/MEMODB"
					,"iot4","1q2q3q!");
			 System.out.println("MySQL접속성공.");
		} catch (Exception e)  {
 	 		System.out.println("MySQL접속 에러.");   // ???
			e.printStackTrace();
		}
	}
	
	void close() {
		
		if(stmt !=null) {
			stmt.close();
		}
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
