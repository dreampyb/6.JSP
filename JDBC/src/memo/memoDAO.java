package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {
	
	Connection conn=null;
	MemoDAO(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(
						"jdbc:mysql://192.168.0.178:38751/MEMODB",
						"iot4","1q2q3q!");
				System.out.println("DB접속 성공");
			} catch (Exception e) {
				System.out.println("DB접속 에러");
				e.printStackTrace();
			}	
		}

	void close() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	ArrayList<MemoDTO> allmemo(){
		PreparedStatement stmt=null;
		ArrayList<MemoDTO> arryDTO = new ArrayList<>();
		try {
			stmt=conn.prepareStatement("select * from memo");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setNo(rs.getInt(1));
				dto.setMemo(rs.getString(2));
				dto.setDate(rs.getDate(3));
				arryDTO.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return arryDTO;
	}
}