package memo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		MemoDAO obj = new MemoDAO();  //db연결
		
		ArrayList<MemoDTO> arryDTO=obj.allmemo(); //쿼리결과 확인
		for(MemoDTO dto:arryDTO) {
			System.out.print(dto.getNo() + "   ");
			System.out.print(dto.getMemo() + "    ");
			System.out.println(dto.getDate());
		}
		
		obj.close();
	}
}