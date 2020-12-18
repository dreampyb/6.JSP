package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementTest {

	public static void main(String[] args) throws Exception {
		// 기존 Statement 이용해서 
		// 게시글에 글번호를 입력하면 글내용을 출력하는 프로그램
		// 출력 예> 보고싶은 글번호: 4
		//          내용은 냉무
		Class.forName("org.mariadb.jdbc.Driver"); //1.드라이버 로딩
		Connection conn=DriverManager.getConnection("jdbc:mariadb://192.168.0.10:3306/testDB"
				,"pyb","wkfgo");
		System.out.println("환영합니다.");
		Statement stmt=conn.createStatement();  //객체생성
		ResultSet rs=stmt.executeQuery("SELECT * FROM board order by BOARD_RE_REF DESC, BOARD_RE_SEQ");
		
		Scanner scan =new Scanner(System.in);
		System.out.print("글번호 검색:");
		String num = scan.nextLine();
		rs=stmt.executeQuery("SELECT board_content FROM board WHERE board_num="+num);
		rs.next();
		System.out.println("내용은"+ rs.getString(1));
 	}
}