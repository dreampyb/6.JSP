package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Board {

	public static void main(String[] args) throws Exception {
		//게시판 목록 보기
		Class.forName("org.mariadb.jdbc.Driver"); //1.드라이버 로딩
		Connection conn=DriverManager.getConnection("jdbc:mariadb://192.168.0.10:3306/testDB"
				,"pyb","wkfgo");
		System.out.println("[Board]에 오신 것을 환영합니다.");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM board order by BOARD_RE_REF DESC, BOARD_RE_SEQ");
		
		while(rs.next()) {	
			if(rs.getInt(12) !=0) {
				System.out.print(rs.getString(12)+"  ");	//No
			}else {
				System.out.print("  ");
			}
			for(int i=0; i<rs.getInt(9); i++){   // 댓글 깊이
				System.out.print("  "); }		
			if (rs.getInt(9) !=0) {
				System.out.print("⤷ re: ");	}	
			// 댓글깊이가 0이 아니라면 ⤷ re표시해라.
				
			System.out.print(rs.getString(1));			// 제목
			System.out.print("♡["+rs.getString(8)+"]"+ " ");	
			System.out.print(rs.getString(3) + " ");	// 작성자
			System.out.print(rs.getString(4) + " ");	// 작성날짜
			System.out.println(rs.getString(5));		// 조회수
			}
		}
	}