package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlConnect {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); //1.드라이버 로딩
		Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.0.178:38751/MEMODB"
				,"iot4","1q2q3q!");
		System.out.println("MySQL접속성공.");
		//Statement stmt=conn.createStatement();
		PreparedStatement stmt=conn.prepareStatement("select*from memo where memo=?");
		Scanner scan = new Scanner(System.in);
		
	boolean flag=true;
	do {
		System.out.print("입력할 메모를 적어주세요 : ");
		String memo=scan.nextLine();
		stmt.setString(1, memo);
		ResultSet rs=stmt.executeQuery( );

			if(rs.next()) {
				System.out.println("동일한 메모가 있습니다");
			}else {
				stmt=conn.prepareStatement("insert into memo(memo)values(?)");
				stmt.setString(1, memo);
				stmt.executeUpdate();	
				flag=false;
			}
		}while(flag);	
		stmt.close();
		scan.close();
		conn.close();
	}
}