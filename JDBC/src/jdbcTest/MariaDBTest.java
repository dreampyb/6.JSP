package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MariaDBTest {

	public static void main(String[] args) {
		// JDBC =Java DAtabase Connectivity
		// JDBC API 라이브러리를 통해 접속
		// JDBC driver

		Connection conn=null;
		Statement stmt=null;
		ResultSet  rs=null;
		Scanner scan=null;
		try {
		Class.forName("org.mariadb.jdbc.Driver"); //1.드라이버 로딩
		
		conn=DriverManager.getConnection("jdbc:mariadb://192.168.0.10:3306/iot"
				,"user1","0123");				// DB 접속
												// RETURN타입이 CONNECTION
		System.out.println("마리아DB 접속 성공");
		stmt=conn.createStatement();			//3. statement 객체 생성
		rs=stmt.executeQuery("select * from user");// 4. Query 요청	
		while(rs.next()) {	// 5. 다음행으로 가기
		System.out.println(rs.getString("id")+"  ");
		System.out.println(rs.getString("pw"));
		}
		//사용자로부터 아이디와 패스워드를 입력받아서 db에 저장
		scan =new Scanner(System.in);

		System.out.print("NO");
		String no = scan.nextLine();
		System.out.print("아이디: ");
		String id = scan.nextLine();
		System.out.print("비밀번호:");
		String pw = scan.nextLine();
		String sql ="insert into user values('" + no + " ','" + id + " ' , ' " + pw + " ')";
		System.out.println("내가 만든 sql: "+sql);
		stmt.executeUpdate(sql);

		System.out.println();
		System.out.println();
		
		// 로그인 기능 구현
		System.out.print("로그인테스트");
		// 1. 사용자로 아이디와 패스워드 입력
		System.out.print("아이디: ");
		id = scan.nextLine();
		System.out.print("비밀번호:");
		pw = scan.nextLine();
		rs.close();
		// 2. 입력받은 아이디로 DB에서 패스워드를 가져온다
		rs=stmt.executeQuery("select pw from user where id=' " +id+ " ' ");
		rs.next();
		String dbpw=rs.getNString("pw");
		// 3. 비교해서 같은면 성공 다르면 실패
		if(pw.equals(dbpw)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}	
		
		}catch(Exception e) {
			// 에러처리
			e.printStackTrace();
		}finally {
			if(rs !=null)
			try {rs.close();
			} catch (SQLException e) {
				e.printStackTrace();}// 에러(e)를 추적하여 보여주는 메소드
			if(stmt !=null)
			try {stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();}
			if(conn !=null)
			try {conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();}
			scan.close();
		}
	}
}