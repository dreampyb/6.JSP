package svc;

import java.sql.Connection;
import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardWriteProService {
	
//	public static void main(String[] args)  {  ???
	public boolean registArticle(BoardBean boardBean) {
		
//	1. DB연결
	Connection conn = JdbcUtil.getConnection();
	
// 	2. 해당 DAO호출
	boolean isWriteSucess=false;   //??
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.setConnection(conn);
	int insertCount=boardDAO.insertArticle(boardBean);
	//BoardDAO 55행 을 이용
// 	3. 트랜젹션 처리
	if(insertCount>0) {
		JdbcUtil.commit(conn);
		isWriteSucess=true;
	}else {
		JdbcUtil.rollback(conn);
		
	}
// 	4. DB연결 닫기
	JdbcUtil.close(conn);
	return isWriteSucess;
	}
}


