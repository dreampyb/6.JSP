package svc;

import java.sql.Connection;
import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardWriteProService {
	
//	public static void main(String[] args)  {  ???
	public boolean registArticle(BoardBean boardBean) {
		
//	1. DB����
	Connection conn = JdbcUtil.getConnection();
	
// 	2. �ش� DAOȣ��
	boolean isWriteSucess=false;   //??
	BoardDAO boardDAO = BoardDAO.getInstance();
	boardDAO.setConnection(conn);
	int insertCount=boardDAO.insertArticle(boardBean);
	//BoardDAO 55�� �� �̿�
// 	3. Ʈ������ ó��
	if(insertCount>0) {
		JdbcUtil.commit(conn);
		isWriteSucess=true;
	}else {
		JdbcUtil.rollback(conn);
		
	}
// 	4. DB���� �ݱ�
	JdbcUtil.close(conn);
	return isWriteSucess;
	}
}


