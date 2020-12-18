package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;

public class BoardDeleteProService {
	//1. ���� ���� �� Ȯ��(�� �н�����)
	
	//2. ���� �����(�۹�ȣ�� �ش��ϴ� �������)
	public boolean removeArticle(int board_num) {
		//1. DB����
		Connection conn = JdbcUtil.getConnection(); //db����� ��ü ����
		
		//2. �ش� DAOȣ��
		boolean isWriteSucess=false;   //Ȯ���ϱ� ���� ���� ����
		BoardDAO boardDAO = BoardDAO.getInstance();//�̱���(�ϳ��� ��ü)��ü ���� 
		boardDAO.setConnection(conn);
		int deleteCount=boardDAO.deleteArticle(board_num);// ����1,������0
		//BoardDAO 55�� �� �̿�
		
		//3. Ʈ������ ó��
		if(deleteCount>0) {
			JdbcUtil.commit(conn);
			isWriteSucess=true;
		}else {
			JdbcUtil.rollback(conn);
			
		}
//	 	4. DB���� �ݱ�
		JdbcUtil.close(conn);
		return isWriteSucess;

	}
}
